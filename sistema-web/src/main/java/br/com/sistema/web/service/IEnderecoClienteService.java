package br.com.sistema.web.service;

import java.util.List;

import br.com.sistema.web.entity.EnderecoCliente;
import br.com.sistema.web.exception.BusinessException;

public interface IEnderecoClienteService {

	EnderecoCliente buscar(Long id) throws BusinessException;

	EnderecoCliente salvar(EnderecoCliente enderecoCliente) throws BusinessException;

	List<EnderecoCliente> listar();

}
