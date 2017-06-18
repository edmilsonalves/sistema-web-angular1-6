package br.com.sistema.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.sistema.web.entity.ProdutoHasAdicional;
import br.com.sistema.web.repository.IProdutoHasAdicionalRepository;
import br.com.sistema.web.service.IProdutoHasAdicionalService;

@Service
@EnableTransactionManagement
public class ProdutoHasAdicionalServiceImpl implements IProdutoHasAdicionalService {

	@Autowired
	private IProdutoHasAdicionalRepository produtoHasAdicionalRepository;

	@Override
	public ProdutoHasAdicional save(ProdutoHasAdicional produtoHasAdicional) {
		return produtoHasAdicionalRepository.save(produtoHasAdicional);
	}


}
