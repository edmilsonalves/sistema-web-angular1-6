package br.com.sistema.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.sistema.web.entity.UsuarioRole;

public interface IUsuarioRoleRepository extends JpaRepository<UsuarioRole, Long>, JpaSpecificationExecutor<UsuarioRole> {

}
