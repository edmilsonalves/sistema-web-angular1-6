package br.com.sistema.web.service;

import java.util.List;

import br.com.sistema.web.entity.Empresa;
import br.com.sistema.web.exception.BusinessException;

public interface IEmpresaService {

	Empresa salvar(Empresa empresa) throws BusinessException;

	List<Empresa> listar();

	Empresa findById(Long id) throws BusinessException;
}
