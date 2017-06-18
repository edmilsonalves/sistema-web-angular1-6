package br.com.sistema.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import br.com.sistema.web.entity.EnderecoCliente;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.repository.IEnderecoClienteRepository;
import br.com.sistema.web.service.IEnderecoClienteService;

@Service
@EnableTransactionManagement
public class EnderecoClienteServiceImpl implements IEnderecoClienteService {

	@Autowired
	private IEnderecoClienteRepository enderecoClienteRepository;

	@Override
	public EnderecoCliente buscar(Long id) throws BusinessException {
		EnderecoCliente enderecoCliente = enderecoClienteRepository.findOne(id);
		if (ObjectUtils.isEmpty(enderecoCliente)) {
			throw new BusinessException("Endereço Cliente nao encontrado.");
		}
		return enderecoCliente;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public EnderecoCliente salvar(EnderecoCliente enderecoCliente) throws BusinessException {
		EnderecoCliente myEnderecoCliente = null;
		try {
			myEnderecoCliente = enderecoClienteRepository.save(enderecoCliente);
		} catch (DataIntegrityViolationException ex) {
			throw new BusinessException("Endereço já existe.");
		}

		return myEnderecoCliente;
	}

	@Override
	public List<EnderecoCliente> listar() {
		return enderecoClienteRepository.findAll();
	}

}
