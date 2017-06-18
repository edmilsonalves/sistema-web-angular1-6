/**
 * Edmilson.Reis
 */
package br.com.sistema.web.rest;

import java.util.concurrent.TimeUnit;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.web.entity.Cliente;
import br.com.sistema.web.entity.Endereco;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.response.DefaultResponse;
import br.com.sistema.web.service.IClienteService;
import br.com.sistema.web.service.IEnderecoService;
import br.com.sistema.web.util.SUtils;
import br.com.sistema.web.view.DataTableView;

/**
 * @author edmilson.reis
 *
 */
@RestController
@RequestMapping("/rest")
public class ClienteRest {

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IEnderecoService enderecoService;

	@CrossOrigin
	@RequestMapping(value = "/clientes/clientesDataTable", method = RequestMethod.GET)
	public ResponseEntity<DataTableView<Cliente>> filtro(@RequestParam("draw") Integer draw,
			@RequestParam("start") Integer start, @RequestParam("length") Integer lenght,
			@RequestParam("order[0][column]") Integer orderColumn, @RequestParam("order[0][dir]") String orderDir,
			@RequestParam(value = "columns[0][name]") String sort,
			@RequestParam(value = "search[value]", required = false) String search) {

		DataTableView<Cliente> myResponse = new DataTableView<Cliente>();
		try {
			Pageable pageable = new PageRequest(start / lenght, lenght, Sort.Direction.fromString(orderDir), sort);

			Page<Cliente> regrasPage = clienteService.listar(pageable, search);

			myResponse.setDraw(draw);
			myResponse.setRecordsTotal(regrasPage.getTotalElements());
			myResponse.setRecordsFiltered(regrasPage.getTotalElements());
			myResponse.setData(regrasPage.getContent());
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
	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		DefaultResponse response = new DefaultResponse();

		try {
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			return ResponseEntity.status(HttpStatus.OK).cacheControl(cache).body(clienteService.listar());
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(SUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@RequestMapping(value = "/clientes/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		DefaultResponse response = new DefaultResponse();

		try {
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			return ResponseEntity.status(HttpStatus.OK).cacheControl(cache).body(clienteService.buscar(id));
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(SUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@CrossOrigin
	@RequestMapping(value = "/clientes/{enderecoId}", method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Cliente cliente, @PathVariable("enderecoId") Long enderecoId) {
		DefaultResponse response = new DefaultResponse();

		try {
			Endereco endereco = enderecoService.buscar(enderecoId);
			cliente.getEnderecoCliente().setEndereco(endereco);
			clienteService.salvar(cliente);
			response.setTypeError(SUtils.E_USER_SUCESS);
			response.setMessage("Operação realizada com sucesso.");
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
	@RequestMapping(value = "/clientes/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> excluir(@PathVariable("id") Long id) {
		DefaultResponse response = new DefaultResponse();

		try {
			clienteService.excluir(id);
			response.setTypeError(SUtils.E_USER_SUCESS);
			response.setMessage("Cliente excluido com sucesso.");
		} catch (Exception e) {
			response.setTypeError(SUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.ok(response);
	}

}
