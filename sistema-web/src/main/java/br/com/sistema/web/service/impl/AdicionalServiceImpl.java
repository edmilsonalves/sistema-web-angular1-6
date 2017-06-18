package br.com.sistema.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.sistema.web.entity.Adicional;
import br.com.sistema.web.entity.ProdutoHasAdicional;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.repository.IAdicionalRepository;
import br.com.sistema.web.repository.IProdutoHasAdicionalRepository;
import br.com.sistema.web.service.IAdicionalService;
import br.com.sistema.web.util.SUtils;

@Service
@EnableTransactionManagement
public class AdicionalServiceImpl implements IAdicionalService {

	@Autowired
	private IAdicionalRepository adicionalRepository;

	@Autowired
	private IProdutoHasAdicionalRepository produtoHasAdicionalRepository;

	@Override
	public List<Adicional> findAll() {
		return adicionalRepository.findAll();
	}

	@Override
	public Adicional findById(Long id) {
		return adicionalRepository.findOne(id);
	}

	@Override
	public Adicional save(Adicional adicional) {
		return adicionalRepository.save(adicional);
	}

	@Override
	public void delete(Long adicionalId, Long produtoId) {

		List<ProdutoHasAdicional> produtoHasAdicionalList = produtoHasAdicionalRepository.findByPk(adicionalId);

		if (!SUtils.isNullOrEmpty(produtoHasAdicionalList)) {
			List<String> codBuscaList = new ArrayList<String>();
			produtoHasAdicionalList.forEach(has ->{
				codBuscaList.add(has.getProduto().getCodigoBusca());
			});
			throw new BusinessException("Adicional não pode ser removido, está sendo utilizado nos seguintes produtos: "+codBuscaList);
		}

		adicionalRepository.delete(adicionalId);
	}

}
