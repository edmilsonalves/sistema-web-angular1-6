package br.com.sistema.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "adicional")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Adicional extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -7569957679917861075L;

	@JsonInclude(Include.NON_NULL)
	@Column(name = "descricao")
	private String descricao;

	@JsonInclude(Include.NON_NULL)
	@Column(name = "preco", precision = 10, scale = 2)
	private BigDecimal preco;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "adicional", cascade = CascadeType.ALL)
	private List<ProdutoHasAdicional> produtoHasAdicionaisList = new ArrayList<>();

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the preco
	 */
	public BigDecimal getPreco() {
		return preco;
	}

	/**
	 * @param preco
	 *            the preco to set
	 */
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	/**
	 * @return the produtoHasAdicionaisList
	 */
	public List<ProdutoHasAdicional> getProdutoHasAdicionaisList() {
		return produtoHasAdicionaisList;
	}

	/**
	 * @param produtoHasAdicionaisList
	 *            the produtoHasAdicionaisList to set
	 */
	public void setProdutoHasAdicionaisList(List<ProdutoHasAdicional> produtoHasAdicionaisList) {
		this.produtoHasAdicionaisList = produtoHasAdicionaisList;
	}

}
