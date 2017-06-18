package br.com.sistema.web.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.web.entity.Usuario;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.response.DefaultResponse;
import br.com.sistema.web.service.IEmailSenderService;
import br.com.sistema.web.service.IUsuarioService;
import br.com.sistema.web.util.SUtils;

/**
 * @author edmilson.reis
 *
 */
@RestController
@RequestMapping("/rest")
public class RecuperaAcessoRest {

	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private IEmailSenderService emailSenderService;

	@CrossOrigin
	@RequestMapping(value = "/recupera-acesso", method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody Usuario usuario) {
		DefaultResponse response = new DefaultResponse();

		try {
			usuario = usuarioService.recuperarAcesso(usuario.getEmail());
			sendSenhaEmail(usuario);
			response.setTypeError(SUtils.E_USER_SUCESS);
			response.setMessage("Acesso recuperado com sucesso!");
		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(SUtils.E_USER_WARNING);
			response.setMessage("Erro ao recuperar acesso!");
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	public void sendSenhaEmail(Usuario usuario) throws BusinessException {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("subject", "Reset Senha - DISK-WEB");
		data.put("nome", usuario.getNome());
		data.put("novaSenha", usuario.getPassword());
		this.emailSenderService.sendTestEmail(SUtils.EMAIL_TEST_SENDER, data);
	}
}
