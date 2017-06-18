package br.com.sistema.web.service;

import java.util.List;

import br.com.sistema.web.entity.ObservacaoProduto;

public interface IObservacaoProdutoService {

	List<ObservacaoProduto> findAll();

	ObservacaoProduto findById(Long id);

	ObservacaoProduto save(ObservacaoProduto observacaoProduto);

	void delete(Long id);

}
