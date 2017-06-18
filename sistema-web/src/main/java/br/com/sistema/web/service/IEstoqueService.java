package br.com.sistema.web.service;

import br.com.sistema.web.entity.Estoque;
import br.com.sistema.web.exception.BusinessException;

public interface IEstoqueService {

	Estoque findById(Long id) throws BusinessException;

	Estoque save(Estoque estoque) throws BusinessException;
}
