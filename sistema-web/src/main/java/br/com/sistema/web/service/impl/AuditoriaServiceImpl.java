package br.com.sistema.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ObjectUtils;

import br.com.sistema.web.entity.Auditoria;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.repository.IAuditoriaRepository;
import br.com.sistema.web.service.IAuditoriaService;

@Service
@EnableTransactionManagement
public class AuditoriaServiceImpl implements IAuditoriaService {

	@Autowired
	private IAuditoriaRepository auditoriaRepository;

	@Override
	public void salvar(Auditoria auditoria) {
		if (ObjectUtils.isEmpty(auditoria)) {
			throw new BusinessException("Preencha os campos obrigatórios.");
		}
		auditoriaRepository.save(auditoria);
	}

}
