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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "movimentacao_has_estoque")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class MovimentacaoHasEstoque implements Serializable {

	private static final long serialVersionUID = 2952693719211251315L;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "estoqueId", column = @Column(name = "estoque_id", nullable = false)),
			@AttributeOverride(name = "movimentacaoEstoqueId", column = @Column(name = "movimentacao_estoque_id", nullable = false)) })
	private MovimentacaoHasEstoqueId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "movimentacao_estoque_id", nullable = false, insertable = false, updatable = false)
	private MovimentacaoEstoque movimentacaoEstoque;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estoque_id", nullable = false, insertable = false, updatable = false)
	private Estoque estoque;

	/**
	 * @return the id
	 */
	public MovimentacaoHasEstoqueId getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(MovimentacaoHasEstoqueId id) {
		this.id = id;
	}

	/**
	 * @return the movimentacaoEstoque
	 */
	public MovimentacaoEstoque getMovimentacaoEstoque() {
		return movimentacaoEstoque;
	}

	/**
	 * @param movimentacaoEstoque
	 *            the movimentacaoEstoque to set
	 */
	public void setMovimentacaoEstoque(MovimentacaoEstoque movimentacaoEstoque) {
		this.movimentacaoEstoque = movimentacaoEstoque;
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

}
