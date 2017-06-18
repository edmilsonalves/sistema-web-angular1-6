package br.com.sistema.web.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.sistema.web.entity.Produto;
import br.com.sistema.web.exception.BusinessException;

public interface IProdutoService {

	Produto salvar(Produto produto) throws BusinessException;

	void excluir(Long id) throws BusinessException;

	List<Produto> findByNomeStartingWith(String nome);

	void verificaExistencia(Produto produto) throws BusinessException;

	Produto buscar(Long id) throws BusinessException;

	Page<Produto> listar(Pageable pageable, String search);

	List<Produto> findByNomeContainingOrCodigoBuscaContaining(String query);

	List<Produto> findByNomeContainingOrCodigoBuscaContainingAndAtivo(String query, boolean ativo);

	List<Produto> findAll();

	Produto findById(Long id);

	Produto findByCodigoBusca(String id);

	List<Produto> findByAtivo(boolean ativo);

}
