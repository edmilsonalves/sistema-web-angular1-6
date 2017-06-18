package br.com.sistema.web.service;

import java.util.List;

import br.com.sistema.web.entity.Endereco;
import br.com.sistema.web.exception.BusinessException;

public interface IEnderecoService {

	Endereco buscar(Long id) throws BusinessException;

	Endereco salvar(Endereco endereco) throws BusinessException;

	List<Endereco> listar();

	List<Endereco> buscarEndereco(String descricao);

	List<Endereco> buscarEnderecoPorCep(String descricao);
}
