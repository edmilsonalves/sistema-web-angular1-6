package br.com.sistema.web.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.sistema.web.entity.Auditoria;
import br.com.sistema.web.entity.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> {

    List<Cliente> findByNomeStartingWith(String nome);
    
    Page<Cliente> findByNomeContainingOrTelefoneContaining(Pageable pageable, String search, String search2);
    
	void save(Auditoria auditoria);

}
