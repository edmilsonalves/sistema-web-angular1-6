package br.com.sistema.web.service;

import br.com.sistema.web.entity.UsuarioRole;
import br.com.sistema.web.exception.BusinessException;

public interface IUsuarioRoleService {

	void salvar(UsuarioRole usuarioRole) throws BusinessException;

}
