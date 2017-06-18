package br.com.sistema.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.sistema.web.entity.Produto;
import br.com.sistema.web.entity.UnidadeMedida;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.repository.IProdutoRepository;
import br.com.sistema.web.repository.IUnidadeMedidaRepository;
import br.com.sistema.web.service.IUnidadeMedidaService;
import br.com.sistema.web.util.SUtils;

@Service
@EnableTransactionManagement
public class UnidadeMedidaServiceImpl implements IUnidadeMedidaService {

	@Autowired
	private IUnidadeMedidaRepository unidadeMedidaRepository;

	@Autowired
	private IProdutoRepository produtoRepository;

	@Override
	public List<UnidadeMedida> findAll() {
		return unidadeMedidaRepository.findAll();
	}

	@Override
	public UnidadeMedida findById(Long id) {
		return unidadeMedidaRepository.findOne(id);
	}

	@Override
	public UnidadeMedida save(UnidadeMedida unidadeMedida) {
		return unidadeMedidaRepository.save(unidadeMedida);
	}

	@Override
	public void delete(Long id) {
		List<Produto> produtoList = produtoRepository.findByToUnidadeMedida(id);

		if (!SUtils.isNullOrEmpty(produtoList)) {
			List<String> codBuscaList = new ArrayList<String>();
			produtoList.forEach(prod -> {
				codBuscaList.add(prod.getCodigoBusca());
			});
			throw new BusinessException(
					"Unidade não pode ser removido, está sendo utilizado nos seguintes produtos: " + codBuscaList);
		}

		unidadeMedidaRepository.delete(id);
	}

}
