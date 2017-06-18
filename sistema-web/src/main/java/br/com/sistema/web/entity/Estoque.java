package br.com.sistema.web.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "estoque")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Estoque extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1830610528555831401L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "unidade_medida_id", nullable = false)
	private UnidadeMedida unidadeMedida;

	@Column(name = "estoque_atual")
	private Integer estoqueAtual;

	@Column(name = "alerta_estoque")
	private Integer alertaEstoque;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estoque")
	private List<MovimentacaoHasEstoque> movimentacaoHasEstoques = new ArrayList<>();

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "estoque")
	private List<Produto> produtos = new ArrayList<>();

	/**
	 * @return the unidadeMedida
	 */
	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	/**
	 * @param unidadeMedida
	 *            the unidadeMedida to set
	 */
	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	/**
	 * @return the estoqueAtual
	 */
	public Integer getEstoqueAtual() {
		return estoqueAtual;
	}

	/**
	 * @param estoqueAtual
	 *            the estoqueAtual to set
	 */
	public void setEstoqueAtual(Integer estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}

	/**
	 * @return the alertaEstoque
	 */
	public Integer getAlertaEstoque() {
		return alertaEstoque;
	}

	/**
	 * @param alertaEstoque
	 *            the alertaEstoque to set
	 */
	public void setAlertaEstoque(Integer alertaEstoque) {
		this.alertaEstoque = alertaEstoque;
	}

	/**
	 * @return the movimentacaoHasEstoques
	 */
	public List<MovimentacaoHasEstoque> getMovimentacaoHasEstoques() {
		return movimentacaoHasEstoques;
	}

	/**
	 * @param movimentacaoHasEstoques
	 *            the movimentacaoHasEstoques to set
	 */
	public void setMovimentacaoHasEstoques(List<MovimentacaoHasEstoque> movimentacaoHasEstoques) {
		this.movimentacaoHasEstoques = movimentacaoHasEstoques;
	}

	/**
	 * @return the produtos
	 */
	public List<Produto> getProdutos() {
		return produtos;
	}

	/**
	 * @param produtos
	 *            the produtos to set
	 */
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
