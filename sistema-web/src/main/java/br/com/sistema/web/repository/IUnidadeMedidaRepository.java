package br.com.sistema.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.sistema.web.entity.UnidadeMedida;

public interface IUnidadeMedidaRepository
		extends JpaRepository<UnidadeMedida, Long>, JpaSpecificationExecutor<UnidadeMedida> {

	UnidadeMedida findByDescricao(String descricao);

}
