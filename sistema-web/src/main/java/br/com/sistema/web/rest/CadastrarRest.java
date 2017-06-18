package br.com.sistema.web.rest;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.web.entity.Empresa;
import br.com.sistema.web.entity.Usuario;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.response.DefaultResponse;
import br.com.sistema.web.service.IEmpresaService;
import br.com.sistema.web.service.IUsuarioService;
import br.com.sistema.web.util.SUtils;

/**
 * @author edmilson.reis
 *
 */
@RestController
@RequestMapping("/rest")
public class CadastrarRest {

	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private IEmpresaService empresaService;

	@CrossOrigin
	@RequestMapping(value = "/cadastrar-se", method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		DefaultResponse response = new DefaultResponse();

		try {
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);
			return ResponseEntity.status(HttpStatus.OK).cacheControl(cache).body(empresaService.listar());
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(SUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@CrossOrigin
	@RequestMapping(value = "/cadastrar-se", method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Usuario usuario) {
		DefaultResponse response = new DefaultResponse();

		try {
			Empresa empresa = empresaService.salvar(usuario.getEmpresa());
			usuario.setEmpresaTenantId(empresa.getId() + "");
			usuario.setAtivo(true);
			usuario = usuarioService.salvar(usuario);

			usuarioService.autologin(usuario);

			response.setRedirect("dashboard.html");
			response.setTypeError(SUtils.E_USER_SUCESS);
			response.setMessage("Usuario incluido com sucesso.");
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(SUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
