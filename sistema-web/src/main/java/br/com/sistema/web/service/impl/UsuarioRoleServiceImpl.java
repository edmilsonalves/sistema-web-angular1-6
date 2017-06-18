package br.com.sistema.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.sistema.web.entity.UsuarioRole;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.repository.IUsuarioRoleRepository;
import br.com.sistema.web.service.IUsuarioRoleService;

@Service
@EnableTransactionManagement
public class UsuarioRoleServiceImpl implements IUsuarioRoleService {

	@Autowired
	private IUsuarioRoleRepository usuarioRoleRepository;

	@Override
	public void salvar(UsuarioRole usuarioRole) throws BusinessException {
		try {
			usuarioRoleRepository.save(usuarioRole);
		} catch (Exception e) {
			throw new BusinessException("Ocorreu um erro na solicitação: " + e.getMessage());
		}
	}

}
