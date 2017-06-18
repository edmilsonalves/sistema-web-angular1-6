package br.com.sistema.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import br.com.sistema.web.entity.ObservacaoProduto;
import br.com.sistema.web.entity.Produto;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.repository.IObservacaoProdutoRepository;
import br.com.sistema.web.repository.IProdutoRepository;
import br.com.sistema.web.service.IProdutoService;
import br.com.sistema.web.util.SUtils;

@Service
@EnableTransactionManagement
public class ProdutoServiceImpl implements IProdutoService {

	@Autowired
	private IProdutoRepository produtoRepository;

	@Autowired
	private IObservacaoProdutoRepository observacaOrodutoRepository;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Produto salvar(Produto produto) throws BusinessException {

		if (!SUtils.isNullOrEmpty(produto.getCodigoBusca())) {
			Produto produtoPK = produtoRepository.findByCodigoBuscaAndEmpresaTenantId(produto.getCodigoBusca(),
					SUtils.getEmpresaLogada());

			if (!SUtils.isNull(produtoPK) && !produtoPK.getId().equals(produto.getId())) {
				throw new BusinessException("Esse Código busca já está sendo utilizado em outro produto!");
			}
		}
		return produtoRepository.save(produto);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public List<Produto> findByNomeStartingWith(String nome) {
		List<Produto> produtoList = produtoRepository.findByNomeStartingWith(nome);

		if (CollectionUtils.isEmpty(produtoList)) {
			throw new BusinessException("Nenhuma produto encontrado.");
		}

		return produtoList;
	}

	@Override
	public void verificaExistencia(Produto produto) throws BusinessException {
		buscar(produto.getId());
	}

	@Override
	public Produto buscar(Long id) throws BusinessException {
		Produto produto = produtoRepository.findOne(id);
		if (ObjectUtils.isEmpty(produto)) {
			throw new BusinessException("Nenhum produto encontrado.");
		}
		return produto;
	}

	@Override
	public Page<Produto> listar(Pageable pageable, String search) {
		return produtoRepository.findByNomeContainingOrCodigoBuscaContaining(pageable, search, search);
	}

	@Override
	public void excluir(Long id) throws BusinessException {

		// foi necessario buscar o produto novamente para pode recuperar a
		// classe Produto no
		// metodo doBasicDomainAuditoriaDelete da classe AuditoriaAspect
		Produto produto = produtoRepository.findOne(id);
		produtoRepository.delete(produto);
	}

	@Override
	public List<Produto> findAll() {
		List<Produto> produtoList =  produtoRepository.findAll();
		List<ObservacaoProduto> observacaoProdutoList = observacaOrodutoRepository.findAll();

		for(Produto prod : produtoList){
			for(ObservacaoProduto obs : observacaoProdutoList){
				if(prod.getCategoriaProduto().getId().equals(obs.getCategoriaProduto().getId())){
					prod.getObservacaoProdutoList().add(obs);
				}
			}
		}

		return produtoRepository.findAll();
	}

	@Override
	public Produto findById(Long id) {
		return produtoRepository.findOne(id);
	}

	@Override
	public List<Produto> findByNomeContainingOrCodigoBuscaContaining(String query) {
		return produtoRepository.findByNomeContainingOrCodigoBuscaContaining(query, query);
	}

	@Override
	public List<Produto> findByNomeContainingOrCodigoBuscaContainingAndAtivo(String query, boolean ativo) {
		return produtoRepository.findByNomeContainingOrCodigoBuscaContainingAndAtivo(query, query, ativo);
	}

	@Override
	public Produto findByCodigoBusca(String id) {
		return produtoRepository.findByCodigoBusca(id);
	}

	@Override
	public List<Produto> findByAtivo(boolean ativo) {
		return produtoRepository.findByAtivo(ativo);
	}

}
