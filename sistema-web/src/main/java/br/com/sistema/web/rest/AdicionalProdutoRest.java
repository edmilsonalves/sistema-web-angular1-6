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
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.web.entity.Adicional;
import br.com.sistema.web.entity.Produto;
import br.com.sistema.web.entity.ProdutoHasAdicional;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.response.BaseResponse;
import br.com.sistema.web.service.IAdicionalService;
import br.com.sistema.web.service.IProdutoService;
import br.com.sistema.web.util.SUtils;

/**
 * @author edmilson.reis
 *
 */
@RestController
@RequestMapping("/rest")
public class AdicionalProdutoRest {

	@Autowired
	private IAdicionalService adicionalService;

	@Autowired
	private IProdutoService produtoService;

	@CrossOrigin
	@RequestMapping(value = "/adicionais", method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		BaseResponse response = new BaseResponse();

		try {
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			response.setDataList(adicionalService.findAll());
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
	@RequestMapping(value = "/adicionais/adicionaisDisponiveisProduto", method = RequestMethod.GET)
	public ResponseEntity<?> adicionaisDisponiveisProduto(@RequestParam(required = false) Long produtoId) {
		BaseResponse response = new BaseResponse();

		try {
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);

			Produto produto = null;

			if(!SUtils.isNull(produtoId)){
				produto = produtoService.findById(produtoId);
			}

			List<Adicional> adicionalProdutoList = new ArrayList<Adicional>();
			if(!SUtils.isNull(produto)){
				for (ProdutoHasAdicional has : produto.getProdutoHasAdicionals()) {
					adicionalProdutoList.add(has.getAdicional());
				}
			}

			List<Adicional> adicionalDisponivelList = adicionalService.findAll();
			adicionalDisponivelList.removeAll(adicionalProdutoList);

			response.setDataList1(adicionalDisponivelList);
			response.setDataList2(adicionalProdutoList);
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
	@RequestMapping(value = "/adicionais/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		BaseResponse response = new BaseResponse();

		try {
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			return ResponseEntity.status(HttpStatus.OK).cacheControl(cache).body(adicionalService.findById(id));
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(SUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@CrossOrigin
	@RequestMapping(value = "/adicionais", method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Adicional adicional) {
		BaseResponse response = new BaseResponse();
		try {
			adicional = adicionalService.save(adicional);
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			response.setDataList(adicionalService.findAll());
			response.setEntity(adicional);
			response.setTypeError(SUtils.E_USER_SUCESS);
			response.setMessage("Adicional salvo com sucesso.");
			return ResponseEntity.status(HttpStatus.OK).cacheControl(cache).body(response);
		} catch (Exception e) {
			response.setError(true);
			response.setTypeError(SUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@CrossOrigin
	@RequestMapping(value = "/adicionais/{adicionalId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> excluir(@PathVariable Long adicionalId, @RequestParam(required = false) Long produtoId) {
		BaseResponse response = new BaseResponse();

		try {
			adicionalService.delete(adicionalId, produtoId);
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			response.setDataList(adicionalService.findAll());
			response.setTypeError(SUtils.E_USER_SUCESS);
			response.setMessage("Adicional excluido com sucesso.");
			return ResponseEntity.status(HttpStatus.OK).cacheControl(cache).body(response);
		} catch (Exception e) {
			response.setError(true);
			response.setTypeError(SUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.ok(response);
	}

}
