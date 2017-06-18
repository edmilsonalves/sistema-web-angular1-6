package br.com.sistema.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "unidade_medida")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UnidadeMedida extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -8916884266350462236L;

	@Column(name = "descricao", length = 45)
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
