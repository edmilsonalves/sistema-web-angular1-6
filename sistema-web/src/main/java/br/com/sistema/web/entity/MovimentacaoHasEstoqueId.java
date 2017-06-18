package br.com.sistema.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MovimentacaoHasEstoqueId implements Serializable {

	private static final long serialVersionUID = -1763614288906212385L;

	@Column(name = "estoque_id", nullable = false)
	private Long estoqueId;

	@Column(name = "movimentacao_estoque_id", nullable = false)
	private Long movimentacaoEstoqueId;

	/**
	 * @return the estoqueId
	 */
	public Long getEstoqueId() {
		return estoqueId;
	}

	/**
	 * @param estoqueId
	 *            the estoqueId to set
	 */
	public void setEstoqueId(Long estoqueId) {
		this.estoqueId = estoqueId;
	}

	/**
	 * @return the movimentacaoEstoqueId
	 */
	public Long getMovimentacaoEstoqueId() {
		return movimentacaoEstoqueId;
	}

	/**
	 * @param movimentacaoEstoqueId
	 *            the movimentacaoEstoqueId to set
	 */
	public void setMovimentacaoEstoqueId(Long movimentacaoEstoqueId) {
		this.movimentacaoEstoqueId = movimentacaoEstoqueId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estoqueId == null) ? 0 : estoqueId.hashCode());
		result = prime * result + ((movimentacaoEstoqueId == null) ? 0 : movimentacaoEstoqueId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovimentacaoHasEstoqueId other = (MovimentacaoHasEstoqueId) obj;
		if (estoqueId == null) {
			if (other.estoqueId != null)
				return false;
		} else if (!estoqueId.equals(other.estoqueId))
			return false;
		if (movimentacaoEstoqueId == null) {
			if (other.movimentacaoEstoqueId != null)
				return false;
		} else if (!movimentacaoEstoqueId.equals(other.movimentacaoEstoqueId))
			return false;
		return true;
	}

}
