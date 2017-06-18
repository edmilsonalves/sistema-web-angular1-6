package br.com.sistema.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.sistema.web.entity.Empresa;

public interface IEmpresaRepository
		extends JpaRepository<Empresa, Long>, JpaSpecificationExecutor<Empresa> {

}
