/**
 * Edmilson.Reis
 */
package br.com.sistema.web.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.web.entity.Pedido;
import br.com.sistema.web.entity.Produto;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.response.BaseResponse;
import br.com.sistema.web.service.IAdicionalService;
import br.com.sistema.web.service.ICategoriaProdutoService;
import br.com.sistema.web.service.IEstoqueService;
import br.com.sistema.web.service.IProdutoService;
import br.com.sistema.web.util.SUtils;

/**
 * @author edmilson.reis
 *
 */
@RestController
@RequestMapping("/rest")
public class VendaDeliveryRest {

	@Autowired
	private IProdutoService produtoService;

	@Autowired
	private ICategoriaProdutoService categoriaProdutoService;

	@Autowired
	private IAdicionalService adicionalService;

	@Autowired
	private IEstoqueService estoqueService;

	@CrossOrigin
	@RequestMapping(value = "/delivery/pesquisa", method = RequestMethod.GET)
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
			} else if (SUtils.isNullOrEmpty(query) && incluirInativos) {
				list = produtoService.findAll();
			} else {
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
	@RequestMapping(value = "/delivery/produtos", method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		BaseResponse response = new BaseResponse();

		try {
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			response.setDataList(produtoService.findAll());
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

	@RequestMapping(value = "/delivery/pedido", method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Pedido pedido) {
		BaseResponse response = new BaseResponse();

		try {
			response.setEntity(null);
			response.setTypeError(SUtils.E_USER_SUCESS);
			response.setMessage("Registro salvo com sucesso.");
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
	@RequestMapping(value = "/delivery/produtos/{id}", method = RequestMethod.DELETE)
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
}
