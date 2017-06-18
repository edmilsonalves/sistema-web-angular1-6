package br.com.sistema.web.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.sistema.web.entity.Endereco;


public interface IEnderecoRepository extends JpaRepository<Endereco, Long>, JpaSpecificationExecutor<Endereco> {
	
	  //@Query("SELECT endereco FROM Endereco endereco where endereco.logradouro like %:descricao% ")
	  //List<Endereco> buscarEndereco(@Param("descricao") String descricao);
	 
	List<Endereco> findByLogradouroContaining(String descricao, Pageable limit);

	List<Endereco> findByCep(String descricao);
}
