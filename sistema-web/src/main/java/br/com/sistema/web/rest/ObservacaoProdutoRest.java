/**
 * Edmilson.Reis
 */
package br.com.sistema.web.rest;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.web.entity.CategoriaProduto;
import br.com.sistema.web.entity.ObservacaoProduto;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.response.BaseResponse;
import br.com.sistema.web.service.ICategoriaProdutoService;
import br.com.sistema.web.service.IObservacaoProdutoService;
import br.com.sistema.web.util.SUtils;

/**
 * @author edmilson.reis
 *
 */
@RestController
@RequestMapping("/rest")
public class ObservacaoProdutoRest {

	@Autowired
	private IObservacaoProdutoService observacaoProdutoService;

	@Autowired
	private ICategoriaProdutoService categoriaProdutoService;

	@CrossOrigin
	@RequestMapping(value = "/observacoes", method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		BaseResponse response = new BaseResponse();

		try {
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			response.setDataList(observacaoProdutoService.findAll());
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
	@RequestMapping(value = "/observacoes/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		BaseResponse response = new BaseResponse();

		try {
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			return ResponseEntity.status(HttpStatus.OK).cacheControl(cache).body(observacaoProdutoService.findById(id));
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(SUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@CrossOrigin
	@RequestMapping(value = "/observacoes", method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody ObservacaoProduto observacao) {
		BaseResponse response = new BaseResponse();
		try {
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			CategoriaProduto cat = categoriaProdutoService.findById(observacao.getCategoriaProduto().getId());
			observacao.setCategoriaProduto(cat);
			observacao = observacaoProdutoService.save(observacao);
			response.setDataList(observacaoProdutoService.findAll());
			response.setEntity(observacao);
			response.setTypeError(SUtils.E_USER_SUCESS);
			response.setMessage("Registro salvo com sucesso.");
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
	@RequestMapping(value = "/observacoes/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		BaseResponse response = new BaseResponse();

		try {
			observacaoProdutoService.delete(id);
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			response.setDataList(observacaoProdutoService.findAll());
			response.setTypeError(SUtils.E_USER_SUCESS);
			response.setMessage("ObservacaoProduto excluido com sucesso.");
			return ResponseEntity.status(HttpStatus.OK).cacheControl(cache).body(response);
		} catch (Exception e) {
			response.setError(true);
			response.setTypeError(SUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.ok(response);
	}

	@CrossOrigin
	@RequestMapping(value = "/observacoes/categoriaList", method = RequestMethod.GET)
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
}
