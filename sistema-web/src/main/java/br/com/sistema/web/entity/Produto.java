package br.com.sistema.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.sistema.web.util.SUtils;

@Entity
@Table(name = "produto", uniqueConstraints = @UniqueConstraint(columnNames = "codigo_busca"))
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Produto extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -5173864018910487848L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoria_produto_id", nullable = false)
	@JsonInclude(Include.NON_NULL)
	private CategoriaProduto categoriaProduto;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estoque_id", nullable = false)
	private Estoque estoque;

	@Column(name = "codigo_busca", unique = true, length = 45)
	@JsonInclude(Include.NON_NULL)
	private String codigoBusca;

	@Column(name = "nome", length = 45)
	@JsonInclude(Include.NON_NULL)
	private String nome;

	@Column(name = "preco_venda", precision = 10, scale = 2)
	@JsonInclude(Include.NON_NULL)
	private BigDecimal precoVenda;

	@Column(name = "preco_custo", precision = 10, scale = 2)
	@JsonInclude(Include.NON_NULL)
	private BigDecimal precoCusto;

	@Column(name = "path_imagem", precision = 10, scale = 2)
	private String pathImagem;

	@Column(name = "nome_imagem", precision = 10, scale = 2)
	private String nomeImagem;

	@Column(name = "ativo", nullable = false)
	private Boolean ativo;

	@JsonManagedReference
	@JsonInclude(Include.NON_NULL)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProdutoHasAdicional> produtoHasAdicionals = new ArrayList<>();

	@Transient
	private List<ObservacaoProduto> observacaoProdutoList;

	/**
	 * @return the categoriaProduto
	 */
	public CategoriaProduto getCategoriaProduto() {
		return categoriaProduto;
	}

	/**
	 * @param categoriaProduto
	 *            the categoriaProduto to set
	 */
	public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	/**
	 * @return the codigoBusca
	 */
	public String getCodigoBusca() {
		return codigoBusca;
	}

	/**
	 * @param codigoBusca
	 *            the codigoBusca to set
	 */
	public void setCodigoBusca(String codigoBusca) {
		this.codigoBusca = codigoBusca;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the precoVenda
	 */
	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	/**
	 * @param precoVenda
	 *            the precoVenda to set
	 */
	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	/**
	 * @return the precoCusto
	 */
	public BigDecimal getPrecoCusto() {
		return precoCusto;
	}

	/**
	 * @param precoCusto
	 *            the precoCusto to set
	 */
	public void setPrecoCusto(BigDecimal precoCusto) {
		this.precoCusto = precoCusto;
	}

	/**
	 * @return the produtoHasAdicionals
	 */
	public List<ProdutoHasAdicional> getProdutoHasAdicionals() {
		return produtoHasAdicionals;
	}

	/**
	 * @param produtoHasAdicionals
	 *            the produtoHasAdicionals to set
	 */
	public void setProdutoHasAdicionals(List<ProdutoHasAdicional> produtoHasAdicionals) {
		this.produtoHasAdicionals = produtoHasAdicionals;
	}

	/**
	 * @return the estoque
	 */
	public Estoque getEstoque() {
		return estoque;
	}

	/**
	 * @param estoque
	 *            the estoque to set
	 */
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	/**
	 * @return the pathImagem
	 */
	public String getPathImagem() {
		return pathImagem;
	}

	/**
	 * @param pathImagem
	 *            the pathImagem to set
	 */
	public void setPathImagem(String pathImagem) {
		this.pathImagem = pathImagem;
	}

	/**
	 * @return the nomeImagem
	 */
	public String getNomeImagem() {
		return nomeImagem;
	}

	/**
	 * @param nomeImagem
	 *            the nomeImagem to set
	 */
	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	/**
	 * @return the ativo
	 */
	public Boolean getAtivo() {
		return ativo;
	}

	/**
	 * @param ativo
	 *            the ativo to set
	 */
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	/**
	 * @return the observacaoProdutoList
	 */
	public List<ObservacaoProduto> getObservacaoProdutoList() {
		if(SUtils.isNull(observacaoProdutoList)){
			observacaoProdutoList = new ArrayList<ObservacaoProduto>();
		}
		return observacaoProdutoList;
	}

	/**
	 * @param observacaoProdutoList
	 *            the observacaoProdutoList to set
	 */
	public void setObservacaoProdutoList(List<ObservacaoProduto> observacaoProdutoList) {
		if(SUtils.isNull(observacaoProdutoList)){
			observacaoProdutoList = new ArrayList<ObservacaoProduto>();
		}
		this.observacaoProdutoList = observacaoProdutoList;
	}

}
