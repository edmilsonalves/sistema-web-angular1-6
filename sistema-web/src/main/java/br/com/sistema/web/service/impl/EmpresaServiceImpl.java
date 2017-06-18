package br.com.sistema.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.sistema.web.entity.Empresa;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.repository.IEmpresaRepository;
import br.com.sistema.web.service.IEmpresaService;

@Service
@EnableTransactionManagement
public class EmpresaServiceImpl implements IEmpresaService {

	@Autowired
	private IEmpresaRepository empresaRepository;

	@Override
	public Empresa salvar(Empresa empresa) throws BusinessException {
		Empresa myEmpresa = null;
		try {
			myEmpresa = empresaRepository.save(empresa);
		} catch (Exception e) {
			throw new BusinessException("Ocorreu um erro na solicitação: " + e.getMessage());
		}

		return myEmpresa;
	}

	@Override
	public List<Empresa> listar() {
		return empresaRepository.findAll();
	}

	@Override
	public Empresa findById(Long id) throws BusinessException {
		return empresaRepository.findOne(id);
	}

}
