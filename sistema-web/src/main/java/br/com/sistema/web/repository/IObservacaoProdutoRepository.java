package br.com.sistema.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.sistema.web.entity.ObservacaoProduto;

public interface IObservacaoProdutoRepository
		extends JpaRepository<ObservacaoProduto, Long>, JpaSpecificationExecutor<ObservacaoProduto> {

}
