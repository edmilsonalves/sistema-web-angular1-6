package br.com.sistema.web.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sistema.web.entity.Auditoria;
import br.com.sistema.web.entity.Produto;

public interface IProdutoRepository extends JpaRepository<Produto, Long>, JpaSpecificationExecutor<Produto> {

	List<Produto> findByNomeStartingWith(String nome);

	Page<Produto> findByNomeContainingOrCodigoBuscaContaining(Pageable pageable, String nome, String codigoBusca);

	List<Produto> findByNomeContainingOrCodigoBuscaContaining(String nome, String codigoBusca);

	@Query("FROM Produto prod WHERE (prod.nome LIKE %:nome% OR prod.codigoBusca LIKE %:codigoBusca%) AND prod.ativo = :ativo")
	List<Produto> findByNomeContainingOrCodigoBuscaContainingAndAtivo(@Param("nome") String nome,
			@Param("codigoBusca") String codigoBusca, @Param("ativo") boolean ativo);

	void save(Auditoria auditoria);

	Produto findByCodigoBusca(String id);

	Produto findById(Long id);

	List<Produto> findByAtivo(boolean ativo);

	@Query("FROM Produto prod JOIN FETCH prod.categoriaProduto cat WHERE cat.id = :categoriaId")
	List<Produto> findByToCategoriaProduto(@Param("categoriaId") Long categoriaId);

	@Query("FROM Produto prod JOIN FETCH prod.estoque.unidadeMedida unid WHERE unid.id = :unidadeMedidaId")
	List<Produto> findByToUnidadeMedida(@Param("unidadeMedidaId") Long unidadeMedidaId);

	Produto findByCodigoBuscaAndEmpresaTenantId(String codigoBusca, String empresaTenantId);

}
