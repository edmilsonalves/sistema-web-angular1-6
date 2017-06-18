/**
 * Edmilson.Reis
 */
package br.com.sistema.web.rest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.sistema.web.entity.Adicional;
import br.com.sistema.web.entity.Produto;
import br.com.sistema.web.entity.ProdutoHasAdicional;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.response.BaseResponse;
import br.com.sistema.web.response.DefaultResponse;
import br.com.sistema.web.service.IAdicionalService;
import br.com.sistema.web.service.ICategoriaProdutoService;
import br.com.sistema.web.service.IEstoqueService;
import br.com.sistema.web.service.IProdutoService;
import br.com.sistema.web.service.IUnidadeMedidaService;
import br.com.sistema.web.util.SUtils;
import br.com.sistema.web.view.DataTableView;

/**
 * @author edmilson.reis
 *
 */
@RestController
@RequestMapping("/rest")
public class ProdutoRest {

	@Autowired
	private IProdutoService produtoService;

	@Autowired
	private ICategoriaProdutoService categoriaProdutoService;

	@Autowired
	private IAdicionalService adicionalService;

	@Autowired
	private IEstoqueService estoqueService;

	@Autowired
	private IUnidadeMedidaService unidadeMedidaService;

	@Autowired
	HttpServletRequest request;

	@CrossOrigin
	@RequestMapping(value = "/produtos/produtosDataTable", method = RequestMethod.GET)
	public ResponseEntity<DataTableView<Produto>> filtro(@RequestParam("draw") Integer draw,
			@RequestParam("start") Integer start, @RequestParam("length") Integer lenght,
			@RequestParam("order[0][column]") Integer orderColumn, @RequestParam("order[0][dir]") String orderDir,
			@RequestParam(value = "columns[0][name]") String sort,
			@RequestParam(value = "search[value]", required = false) String search) {

		DataTableView<Produto> myResponse = new DataTableView<Produto>();
		try {
			Pageable pageable = new PageRequest(start / lenght, lenght, Sort.Direction.fromString(orderDir), sort);

			Page<Produto> data = produtoService.listar(pageable, search);

			myResponse.setDraw(draw);
			myResponse.setRecordsTotal(data.getTotalElements());
			myResponse.setRecordsFiltered(data.getTotalElements());
			myResponse.setData(data.getContent());
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			return ResponseEntity.status(HttpStatus.OK).cacheControl(cache).body(myResponse);
		} catch (Exception e) {
			myResponse.setError(true);
			myResponse.setTypeError(SUtils.E_USER_WARNING);
			myResponse.setMessage(e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body(myResponse);
	}

	@CrossOrigin
	@RequestMapping(value = "/produtos/pesquisa", method = RequestMethod.GET)
	public ResponseEntity<?> pesquisa(@RequestParam(required = false) String query,
			@RequestParam(required = false) boolean incluirInativos) {
		BaseResponse response = new BaseResponse();

		try {
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			List<Produto> list = new ArrayList<Produto>();

			if (!SUtils.isNullOrEmpty(query) && !incluirInativos) {
				list = produtoService.findByNomeContainingOrCodigoBuscaContainingAndAtivo(query, true);
			} else if (!SUtils.isNullOrEmpty(query) && incluirInativos) {
				list = produtoService.findByNomeContainingOrCodigoBuscaContaining(query);
			} else if(SUtils.isNullOrEmpty(query) && incluirInativos) {
				list = produtoService.findAll();
			}else{
				list = produtoService.findByAtivo(true);
			}

			response.setDataList(list);
			response.setTypeError(SUtils.E_USER_SUCESS);
			response.setMessage("Consulta realizada com sucesso.");
			return ResponseEntity.status(HttpStatus.OK).cacheControl(cache).body(response);
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(SUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@CrossOrigin
	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		DefaultResponse response = new DefaultResponse();

		try {
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			List<Produto> list = new ArrayList<Produto>();

			list = produtoService.findAll();
			response.setTypeError(SUtils.E_USER_SUCESS);
			response.setMessage("Consulta realizada com sucesso.");
			return ResponseEntity.status(HttpStatus.OK).cacheControl(cache).body(list);
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(SUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") String id) {
		BaseResponse response = new BaseResponse();

		try {
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			Produto produto = produtoService.findByCodigoBusca(id);

			List<Adicional> adicionalProdutoList = new ArrayList<Adicional>();

			if (!SUtils.isNull(produto)) {
				for (ProdutoHasAdicional has : produto.getProdutoHasAdicionals()) {
					adicionalProdutoList.add(has.getAdicional());
				}
			}

			List<Adicional> adicionalDisponivelList = adicionalService.findAll();
			adicionalDisponivelList.removeAll(adicionalProdutoList);

			response.setDataList1(adicionalDisponivelList);
			response.setDataList2(adicionalProdutoList);
			response.setEntity(produto);
			return ResponseEntity.status(HttpStatus.OK).cacheControl(cache).body(response);
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(SUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@RequestMapping(value = "/produtos", method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestPart(value = "produto") Produto produto,
			@RequestPart(value = "file", required = false) MultipartFile arquivo) {
		BaseResponse response = new BaseResponse();

		try {
			saveFile(produto, arquivo);

			Produto produtoSalvo = new Produto();

			if (!SUtils.isNull(produto.getId())) {

				produto.getProdutoHasAdicionals().forEach(has -> {
					has.getPk().setProdutoId(produto.getId());
				});

				produto.setEstoque(estoqueService.save(produto.getEstoque()));
				produtoSalvo = produtoService.salvar(produto);

			} else {
				List<ProdutoHasAdicional> adicionais = new ArrayList<ProdutoHasAdicional>();
				adicionais.addAll(produto.getProdutoHasAdicionals());
				produto.setProdutoHasAdicionals(null);
				produto.setEstoque(estoqueService.save(produto.getEstoque()));

				Produto prod = produtoService.salvar(produto);
				adicionais.forEach(has -> {
					has.getPk().setProdutoId(prod.getId());
				});

				prod.setProdutoHasAdicionals(adicionais);
				produtoSalvo = produtoService.salvar(prod);
			}

			response.setEntity(produtoSalvo);
			response.setTypeError(SUtils.E_USER_SUCESS);
			response.setMessage("Registro alterado com sucesso.");
		} catch (Exception e) {
			response.setError(true);
			response.setTypeError(SUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@CrossOrigin
	@ResponseBody
	@RequestMapping(value = "/produtos/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> excluir(@PathVariable("id") Long id) {
		BaseResponse response = new BaseResponse();

		try {
			produtoService.excluir(id);
			response.setTypeError(SUtils.E_USER_SUCESS);
			response.setMessage("Produto excluido com sucesso.");
		} catch (Exception e) {
			response.setTypeError(SUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.ok(response);
	}

	@CrossOrigin
	@RequestMapping(value = "/produtos/adicionalDispinivelList", method = RequestMethod.GET)
	public ResponseEntity<?> adicionalDispinivelList(@RequestParam(required = false) Long produtoId) {
		DefaultResponse response = new DefaultResponse();

		try {
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);

			Produto produto = null;
			if (!SUtils.isNull(produtoId)) {
				produto = produtoService.findById(produtoId);
			}

			List<Adicional> adicionalProdutoList = new ArrayList<Adicional>();

			if (!SUtils.isNull(produto)) {
				for (ProdutoHasAdicional has : produto.getProdutoHasAdicionals()) {
					adicionalProdutoList.add(has.getAdicional());
				}
			}

			List<Adicional> adicionalDisponivelList = adicionalService.findAll();
			adicionalDisponivelList.removeAll(adicionalProdutoList);

			return ResponseEntity.status(HttpStatus.OK).cacheControl(cache).body(adicionalDisponivelList);
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(SUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@CrossOrigin
	@RequestMapping(value = "/produtos/categoriaList", method = RequestMethod.GET)
	public ResponseEntity<?> categoriaList() {
		BaseResponse response = new BaseResponse();

		try {
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			response.setDataList(categoriaProdutoService.findAll());
			return ResponseEntity.status(HttpStatus.OK).cacheControl(cache).body(response);
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(SUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@CrossOrigin
	@RequestMapping(value = "/produtos/unidadeMedidaList", method = RequestMethod.GET)
	public ResponseEntity<?> unidadeMedidaList() {
		BaseResponse response = new BaseResponse();

		try {
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			response.setTypeError(SUtils.E_USER_SUCESS);
			response.setDataList(unidadeMedidaService.findAll());
			response.setMessage("Consulta realizada com sucesso.");
			return ResponseEntity.status(HttpStatus.OK).cacheControl(cache).body(response);
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(SUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	private void saveFile(Produto produto, MultipartFile arquivo) throws IOException {
		// String path =
		// servletContext.getRealPath("/sistema-web/src/main/webapp/WEB-INF/teste");
		// String path = request.getServletContext().getRealPath("/" +
		// "assets/dist/imagens-produtos/");

		if (!SUtils.isNull(arquivo)) {

			String pastaEmpresaLogada = SUtils.getEmpresaLogada();
			String path = "C:\\Users\\Kauan\\git\\sistema-web\\sistema-web\\src\\main\\webapp\\assets\\imagens-produtos\\"
					+ pastaEmpresaLogada + "\\";

			if (!SUtils.isNull(produto.getId())) {
				String nomeImagem = produto.getNomeImagem();
				if (!SUtils.isNullOrEmpty(nomeImagem)) {
					File fileRemove = new File(path, nomeImagem);
					fileRemove.delete();
				}
			}

			String nomeNovaImagem = SUtils.dataToNomeImg(new Date(), arquivo.getOriginalFilename());
			File fileNew = new File(path, nomeNovaImagem);

			if (!SUtils.isNull(fileNew) && !fileNew.getParentFile().exists())
				fileNew.getParentFile().mkdirs();

			if (!SUtils.isNull(fileNew) && !fileNew.exists()) {
				arquivo.transferTo(fileNew);
				produto.setPathImagem("assets/imagens-produtos/" + pastaEmpresaLogada + "/" + nomeNovaImagem);
				produto.setNomeImagem(nomeNovaImagem);
			}
		}
	}
}
