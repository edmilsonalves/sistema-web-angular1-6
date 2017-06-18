package br.com.sistema.web.service;

import java.util.List;

import br.com.sistema.web.entity.CategoriaProduto;

public interface ICategoriaProdutoService {

	List<CategoriaProduto> findAll();

	CategoriaProduto findById(Long id);

	CategoriaProduto save(CategoriaProduto categoria);

	void delete(Long id);
}
