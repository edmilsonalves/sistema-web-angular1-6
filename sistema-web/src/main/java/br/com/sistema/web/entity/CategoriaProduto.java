package br.com.sistema.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "categoria_produto")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CategoriaProduto extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1220646324499746033L;

	@Column(name = "descricao", nullable = false, length = 45)
	private String descricao;

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

}
