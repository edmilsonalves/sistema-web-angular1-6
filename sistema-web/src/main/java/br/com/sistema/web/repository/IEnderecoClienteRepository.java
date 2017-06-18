package br.com.sistema.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.sistema.web.entity.EnderecoCliente;

public interface IEnderecoClienteRepository
		extends JpaRepository<EnderecoCliente, Long>, JpaSpecificationExecutor<EnderecoCliente> {

}
