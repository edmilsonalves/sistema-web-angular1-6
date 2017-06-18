package br.com.sistema.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.sistema.web.entity.CategoriaProduto;
import br.com.sistema.web.entity.Produto;
import br.com.sistema.web.entity.ProdutoHasAdicional;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.repository.ICategoriaProdutoRepository;
import br.com.sistema.web.repository.IProdutoRepository;
import br.com.sistema.web.service.ICategoriaProdutoService;
import br.com.sistema.web.util.SUtils;

@Service
@EnableTransactionManagement
public class CategoriaProdutoServiceImpl implements ICategoriaProdutoService {

	@Autowired
	private ICategoriaProdutoRepository categoriaProdutoRepository;

	@Autowired
	private IProdutoRepository produtoRepository;

	@Override
	public List<CategoriaProduto> findAll() {
		return categoriaProdutoRepository.findAll();
	}

	@Override
	public CategoriaProduto findById(Long id) {
		return categoriaProdutoRepository.findOne(id);
	}

	@Override
	public CategoriaProduto save(CategoriaProduto categoria) {
		return categoriaProdutoRepository.save(categoria);
	}

	@Override
	public void delete(Long categoriaId) {

		List<Produto> produtoList = produtoRepository.findByToCategoriaProduto(categoriaId);

		if (!SUtils.isNullOrEmpty(produtoList)) {
			List<String> codBuscaList = new ArrayList<String>();
			produtoList.forEach(prod ->{
				codBuscaList.add(prod.getCodigoBusca());
			});
			throw new BusinessException("Categoria não pode ser removido, está sendo utilizado nos seguintes produtos: "+codBuscaList);
		}

		categoriaProdutoRepository.delete(categoriaId);
	}

}
