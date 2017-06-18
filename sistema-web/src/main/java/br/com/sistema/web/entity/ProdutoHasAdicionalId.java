package br.com.sistema.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProdutoHasAdicionalId implements Serializable {

	private static final long serialVersionUID = 853893293070293926L;

	@Column(name = "produto_id", nullable = false)
	private Long produtoId;

	@Column(name = "adicional_id", nullable = false)
	private Long adicionalId;

	/**
	 * @return the produtoId
	 */
	public Long getProdutoId() {
		return produtoId;
	}

	/**
	 * @param produtoId
	 *            the produtoId to set
	 */
	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	/**
	 * @return the adicionalId
	 */
	public Long getAdicionalId() {
		return adicionalId;
	}

	/**
	 * @param adicionalId
	 *            the adicionalId to set
	 */
	public void setAdicionalId(Long adicionalId) {
		this.adicionalId = adicionalId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adicionalId == null) ? 0 : adicionalId.hashCode());
		result = prime * result + ((produtoId == null) ? 0 : produtoId.hashCode());
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
		ProdutoHasAdicionalId other = (ProdutoHasAdicionalId) obj;
		if (adicionalId == null) {
			if (other.adicionalId != null)
				return false;
		} else if (!adicionalId.equals(other.adicionalId))
			return false;
		if (produtoId == null) {
			if (other.produtoId != null)
				return false;
		} else if (!produtoId.equals(other.produtoId))
			return false;
		return true;
	}

}
