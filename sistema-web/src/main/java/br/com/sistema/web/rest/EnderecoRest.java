/**
 * Edmilson.Reis
 */
package br.com.sistema.web.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.sistema.web.dto.EnderecoDTO;
import br.com.sistema.web.entity.Endereco;
import br.com.sistema.web.enums.EstadosEnum;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.response.DefaultResponse;
import br.com.sistema.web.service.IEnderecoService;
import br.com.sistema.web.util.SUtils;

/**
 * @author edmilson.reis
 *
 */
@RestController
@RequestMapping("/rest")
public class EnderecoRest {

	private static final Logger LOGGER = Logger.getLogger(EnderecoRest.class.getName());

	@Autowired
	private IEnderecoService enderecoService;

	@CrossOrigin
	@RequestMapping(value = "/enderecos/{descricao}", method = RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable(value = "descricao", required = false) String descricao) {
		DefaultResponse response = new DefaultResponse();

		try {
			CacheControl cache = CacheControl.maxAge(10800, TimeUnit.SECONDS);

			if (!SUtils.isNull(descricao) && descricao.length() > 3) {
				List<Endereco> enderecoList = new ArrayList<Endereco>();

				if (!SUtils.isNullOrEmpty(descricao) && !cepValido(descricao)) {
					LOGGER.info("Buscou pelo logradouro");
					// busca na base local pelo logradouro
					enderecoList = enderecoService.buscarEndereco(descricao);
				}

				if (SUtils.isNullOrEmpty(enderecoList)) {

					String cep = getCep(descricao);
					if (!SUtils.isNullOrEmpty(cep) && cepValido(cep)) {
						LOGGER.info("Buscou pelo cep");
						// busca na base local pelo cep
						enderecoList = enderecoService.buscarEnderecoPorCep(cep);
					}

					if (SUtils.isNullOrEmpty(enderecoList) && !SUtils.isNullOrEmpty(cep) && cepValido(cep)) {
						LOGGER.info("Buscou na base remota pelo cep");
						enderecoList = new ArrayList<Endereco>();
						Endereco endereco = endereco(cep);
						if (!SUtils.isNull(endereco)) {
							endereco = enderecoService.salvar(endereco);
							enderecoList.add(endereco);
						}
					}

				}

				return ResponseEntity.status(HttpStatus.OK).cacheControl(cache).body(enderecoList);
			}

		} catch (BusinessException e) {
			response.setError(true);
			response.setTypeError(SUtils.E_USER_WARNING);
			response.setMessage(e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	/**
	 * Caso não encontre pelo logradouro e nem pelo cep, é feito uma consulta
	 * webservice para buscar pelo cep
	 * 
	 * @param cep
	 * @return
	 */
	private Endereco endereco(String cep) {
		if (!SUtils.isNull(cep)) {
			RestTemplate restTemplate = new RestTemplate();
			EnderecoDTO dto = restTemplate.getForObject("http://viacep.com.br/ws/" + cep + "/json", EnderecoDTO.class);
			if (!SUtils.isNull(dto)) {
				Endereco endereco = new Endereco();
				endereco.setCidade(dto.getLocalidade());
				endereco.setLogradouro(dto.getLogradouro());
				endereco.setBairro(dto.getBairro());
				endereco.setCep(dto.getCep());
				endereco.setUf(dto.getUf());
				EstadosEnum estadoEnum = EstadosEnum.valueOf(dto.getUf());
				endereco.setDescricaoUf(estadoEnum.getNome());
				endereco.setName(
						dto.getLogradouro() + " " + dto.getBairro() + ", " + dto.getLocalidade() + " - " + dto.getUf());
				return endereco;
			}
		}
		return null;
	}

	/**
	 * Coloca hifen no cep
	 * 
	 * @param cep
	 * @return
	 */
	private String getCep(String cep) {
		if (!SUtils.isNullOrEmpty(cep)) {
			cep = cep.replaceAll("-", "");
		}
		if (SUtils.isNumeric(cep) && cep.length() == 8) {
			String a = cep.substring(0, 5);
			String b = cep.substring(5, 8);
			cep = a + "-" + b;
		} else {
			cep = "";
		}

		return cep;
	}

	private boolean cepValido(String cep) {
		cep = getCep(cep);
		String padrao = "\\d{5}-\\d{3}";

		if (cep.matches(padrao)) {
			System.out.println("cep válido");
			return true;
		}
		return false;
	}

}
