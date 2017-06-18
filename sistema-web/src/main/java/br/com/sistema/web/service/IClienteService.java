package br.com.sistema.web.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.sistema.web.entity.Cliente;
import br.com.sistema.web.exception.BusinessException;

public interface IClienteService {

    Cliente salvar(Cliente cliente) throws BusinessException;

    void excluir(Long id) throws BusinessException;

    List<Cliente> findByNomeStartingWith(String nome);

    void verificaExistencia(Cliente clienet) throws BusinessException;

    Cliente buscar(Long id) throws BusinessException;

	Page<Cliente> listar(Pageable pageable, String search);

	List<Cliente> listar();

}
