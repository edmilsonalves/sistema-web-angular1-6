package br.com.sistema.web.service;

import br.com.sistema.web.entity.Usuario;
import br.com.sistema.web.exception.BusinessException;

public interface IUsuarioService {

	Usuario salvar(Usuario usuario) throws BusinessException;

	void autologin(Usuario usuario) throws BusinessException;

	Usuario findById(Long id) throws BusinessException;

	Usuario recuperarAcesso(String email) throws BusinessException;

}
