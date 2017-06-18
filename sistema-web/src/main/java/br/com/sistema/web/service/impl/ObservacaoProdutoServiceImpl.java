package br.com.sistema.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.sistema.web.entity.ObservacaoProduto;
import br.com.sistema.web.repository.IObservacaoProdutoRepository;
import br.com.sistema.web.service.IObservacaoProdutoService;

@Service
@EnableTransactionManagement
public class ObservacaoProdutoServiceImpl implements IObservacaoProdutoService {

	@Autowired
	private IObservacaoProdutoRepository observacaoProdutoRepository;

	@Override
	public List<ObservacaoProduto> findAll() {
		return observacaoProdutoRepository.findAll();
	}

	@Override
	public ObservacaoProduto findById(Long id) {
		return observacaoProdutoRepository.findOne(id);
	}

	@Override
	public ObservacaoProduto save(ObservacaoProduto adicional) {
		return observacaoProdutoRepository.save(adicional);
	}

	@Override
	public void delete(Long id) {
		observacaoProdutoRepository.delete(id);
	}

}
