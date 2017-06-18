package br.com.sistema.web.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "movimentacao_estoque")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class MovimentacaoEstoque extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -3681122829980674751L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "tipo", length = 15)
	private String tipo;

	@Column(name = "quantidade")
	private Integer quantidade;

	@Temporal(TemporalType.DATE)
	@Column(name = "data", length = 10)
	private Date data;

	@Column(name = "usuario", length = 145)
	private String usuario;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "movimentacaoEstoque")
	private List<MovimentacaoHasEstoque> movimentacaoHasEstoquesList = new ArrayList<>();

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade
	 *            the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the movimentacaoHasEstoquesList
	 */
	public List<MovimentacaoHasEstoque> getMovimentacaoHasEstoquesList() {
		return movimentacaoHasEstoquesList;
	}

	/**
	 * @param movimentacaoHasEstoquesList
	 *            the movimentacaoHasEstoquesList to set
	 */
	public void setMovimentacaoHasEstoquesList(List<MovimentacaoHasEstoque> movimentacaoHasEstoquesList) {
		this.movimentacaoHasEstoquesList = movimentacaoHasEstoquesList;
	}

}
