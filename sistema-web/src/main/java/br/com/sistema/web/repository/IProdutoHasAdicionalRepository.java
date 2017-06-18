package br.com.sistema.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sistema.web.entity.ProdutoHasAdicional;

public interface IProdutoHasAdicionalRepository extends JpaRepository<ProdutoHasAdicional, Long>, JpaSpecificationExecutor<ProdutoHasAdicional> {

	@Query("FROM ProdutoHasAdicional has JOIN FETCH has.produto prod JOIN FETCH has.adicional adic WHERE adic.id = :adicionalId")
	List<ProdutoHasAdicional> findByPk(@Param("adicionalId") Long adicionalId);

}
