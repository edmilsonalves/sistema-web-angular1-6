package br.com.sistema.web.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "produto_has_adicional")
public class ProdutoHasAdicional implements Serializable {

	private static final long serialVersionUID = -3972599046976986891L;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "produtoId", column = @Column(name = "produto_id", nullable = false)),
			@AttributeOverride(name = "adicionalId", column = @Column(name = "adicional_id", nullable = false)) })
	private ProdutoHasAdicionalId pk;

	@JsonBackReference
	@JsonInclude(Include.NON_NULL)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "produto_id", nullable = false, insertable = false, updatable = false)
	private Produto produto;

	@JsonInclude(Include.NON_NULL)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "adicional_id", nullable = false, insertable = false, updatable = false)
	private Adicional adicional;

	/**
	 * @return the pk
	 */
	public ProdutoHasAdicionalId getPk() {
		return pk;
	}

	/**
	 * @param pk the pk to set
	 */
	public void setPk(ProdutoHasAdicionalId pk) {
		this.pk = pk;
	}

	/**
	 * @return the produto
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * @param produto
	 *            the produto to set
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	/**
	 * @return the adicional
	 */
	public Adicional getAdicional() {
		return adicional;
	}

	/**
	 * @param adicional
	 *            the adicional to set
	 */
	public void setAdicional(Adicional adicional) {
		this.adicional = adicional;
	}

}
