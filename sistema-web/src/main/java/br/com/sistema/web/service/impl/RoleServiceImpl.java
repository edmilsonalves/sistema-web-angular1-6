package br.com.sistema.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.sistema.web.entity.Role;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.repository.IRoleRepository;
import br.com.sistema.web.service.IRoleService;

@Service
@EnableTransactionManagement
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleRepository roleRepository;

	@Override
	public Role findById(Long id) throws BusinessException {
		return roleRepository.findOne(id);
	}

}
