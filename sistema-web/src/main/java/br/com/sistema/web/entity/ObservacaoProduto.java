package br.com.sistema.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "observacao_produto")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ObservacaoProduto extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -7569957679917861075L;

	@JsonInclude(Include.NON_NULL)
	@Column(name = "descricao")
	private String descricao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoria_produto_id", nullable = false)
	@JsonInclude(Include.NON_NULL)
	private CategoriaProduto categoriaProduto;

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

}
