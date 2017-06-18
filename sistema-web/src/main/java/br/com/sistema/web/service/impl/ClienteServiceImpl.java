package br.com.sistema.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import br.com.sistema.web.entity.Cliente;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.repository.IClienteRepository;
import br.com.sistema.web.service.IClienteService;

@Service
@EnableTransactionManagement
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;

	// @Override
	// public Cliente salvar(Cliente cliente) throws BusinessException {
	// if (ObjectUtils.isEmpty(cliente) ||
	// StringUtils.isEmpty(cliente.getNome())) {
	// throw new BusinessException("Preencha os campos obrigatórios.");
	// }
	//
	// return clienteRepository.save(cliente);
	// }

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Cliente salvar(Cliente cliente) throws BusinessException {
		try {
			cliente = clienteRepository.save(cliente);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}

		return cliente;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public List<Cliente> findByNomeStartingWith(String nome) {
		List<Cliente> clienteList = clienteRepository.findByNomeStartingWith(nome);

		if (CollectionUtils.isEmpty(clienteList)) {
			throw new BusinessException("Nenhum cliente encontrado.");
		}

		return clienteList;
	}

	@Override
	public void verificaExistencia(Cliente cliente) throws BusinessException {
		buscar(cliente.getId());
	}

	@Override
	public Cliente buscar(Long id) throws BusinessException {
		Cliente cliente = clienteRepository.findOne(id);
		if (ObjectUtils.isEmpty(cliente)) {
			throw new BusinessException("Nenhum cliente encontrado.");
		}
		return cliente;
	}

	@Override
	public Page<Cliente> listar(Pageable pageable, String search) {
		return clienteRepository.findByNomeContainingOrTelefoneContaining(pageable, search, search);
	}

	@Override
	public void excluir(Long id) throws BusinessException {

		// foi necessario buscar o cliente novamente para pode recuperar a
		// classe Cliente no
		// metodo doBasicDomainAuditoriaDelete da classe AuditoriaAspect
		Cliente cliente = clienteRepository.findOne(id);
		clienteRepository.delete(cliente);
	}

	@Override
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

}
