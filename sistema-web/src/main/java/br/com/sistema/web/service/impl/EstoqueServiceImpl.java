package br.com.sistema.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ObjectUtils;

import br.com.sistema.web.entity.Estoque;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.repository.IEstoqueRepository;
import br.com.sistema.web.service.IEstoqueService;

@Service
@EnableTransactionManagement
public class EstoqueServiceImpl implements IEstoqueService {

	@Autowired
	private IEstoqueRepository estoqueRepository;

	@Override
	public Estoque findById(Long id) throws BusinessException {
		Estoque estoque = estoqueRepository.findOne(id);
		if (ObjectUtils.isEmpty(estoque)) {
			throw new BusinessException("Estoque nao encontrado.");
		}
		return estoque;
	}

	@Override
	public Estoque save(Estoque estoque) throws BusinessException {
		return estoqueRepository.save(estoque);
	}

}
