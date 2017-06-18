package br.com.sistema.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.sistema.web.entity.CategoriaProduto;


public interface ICategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long>, JpaSpecificationExecutor<CategoriaProduto> {

	CategoriaProduto findByDescricao(String descricao);

}
