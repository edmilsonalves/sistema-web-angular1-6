package br.com.sistema.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import br.com.sistema.web.entity.Endereco;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.repository.IEnderecoRepository;
import br.com.sistema.web.service.IEnderecoService;

@Service
@EnableTransactionManagement
public class EnderecoServiceImpl implements IEnderecoService {

	@Autowired
	private IEnderecoRepository enderecoRepository;

	@Override
	public Endereco buscar(Long id) throws BusinessException {
		Endereco endereco = enderecoRepository.findOne(id);
		if (ObjectUtils.isEmpty(endereco)) {
			throw new BusinessException("Endereço nao encontrado.");
		}
		return endereco;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Endereco salvar(Endereco endereco) throws BusinessException {
		Endereco myEndereco = null;
		try {
			myEndereco = enderecoRepository.save(endereco);
		} catch (DataIntegrityViolationException ex) {
			throw new BusinessException("Endereço já existe.");
		}

		return myEndereco;
	}

	@Override
	public List<Endereco> listar() {
		return enderecoRepository.findAll();
	}

	@Override
	public List<Endereco> buscarEndereco(String descricao) {
		Pageable limit = new PageRequest(0,10);
		return enderecoRepository.findByLogradouroContaining(descricao, limit);
	}

	@Override
	public List<Endereco> buscarEnderecoPorCep(String descricao) {
		return enderecoRepository.findByCep(descricao);
	}

}
