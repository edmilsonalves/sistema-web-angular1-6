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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.web.entity.CategoriaProduto;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.response.BaseResponse;
import br.com.sistema.web.response.DefaultResponse;
import br.com.sistema.web.service.ICategoriaProdutoService;
import br.com.sistema.web.util.SUtils;

/**
 * @author edmilson.reis
 *
 */
@RestController
@RequestMapping("/rest")
public class CategoriaRest {

	@Autowired
	private ICategoriaProdutoService categoriaProdutoService;

	@CrossOrigin
	@RequestMapping(value = "/categorias", method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		BaseResponse response = new BaseResponse();

		try {
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			response.setDataList(categoriaProdutoService.findAll());
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
	@RequestMapping(value = "/categorias/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		DefaultResponse response = new DefaultResponse();

		try {
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			return ResponseEntity.status(HttpStatus.OK).cacheControl(cache).body(categoriaProdutoService.findById(id));
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(SUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@CrossOrigin
	@RequestMapping(value = "/categorias", method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody CategoriaProduto categoria) {
		BaseResponse response = new BaseResponse();
		try {

			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			response.setEntity(categoriaProdutoService.save(categoria));
			response.setDataList(categoriaProdutoService.findAll());
			response.setTypeError(SUtils.E_USER_SUCESS);
			response.setMessage("Categoria salvo com sucesso.");
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
	@RequestMapping(value = "/categorias/{categoriaId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> excluir(@PathVariable Long categoriaId,
			@RequestParam(required = false) String produtoCodigoBusca) {
		BaseResponse response = new BaseResponse();

		try {
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			categoriaProdutoService.delete(categoriaId);
			response.setDataList(categoriaProdutoService.findAll());
			response.setTypeError(SUtils.E_USER_SUCESS);
			response.setMessage("CategoriaProduto excluido com sucesso.");
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
