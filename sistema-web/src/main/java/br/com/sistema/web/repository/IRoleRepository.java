package br.com.sistema.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.sistema.web.entity.Role;

public interface IRoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {

	Role findByNome(String nome);

}
