package br.com.sistema.web.service;

import br.com.sistema.web.entity.Role;
import br.com.sistema.web.exception.BusinessException;

public interface IRoleService {

	Role findById(Long id) throws BusinessException;

}
