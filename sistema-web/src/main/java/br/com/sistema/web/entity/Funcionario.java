package br.com.sistema.web.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario extends BaseEntity implements java.io.Serializable {

	private static final long serialVersionUID = -5295491418726078133L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco_funcionario_id", nullable = false)
	private EnderecoFuncionario enderecoFuncionario;

	@Column(name = "nome", length = 75)
	private String nome;

	@Column(name = "cargo", length = 45)
	private String cargo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "funcionario")
	private List<Pedido> pedidoList = new ArrayList<Pedido>();

	/**
	 * @return the enderecoFuncionario
	 */
	public EnderecoFuncionario getEnderecoFuncionario() {
		return enderecoFuncionario;
	}

	/**
	 * @param enderecoFuncionario
	 *            the enderecoFuncionario to set
	 */
	public void setEnderecoFuncionario(EnderecoFuncionario enderecoFuncionario) {
		this.enderecoFuncionario = enderecoFuncionario;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo
	 *            the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return the pedidoList
	 */
	public List<Pedido> getPedidoList() {
		return pedidoList;
	}

	/**
	 * @param pedidoList
	 *            the pedidoList to set
	 */
	public void setPedidoList(List<Pedido> pedidoList) {
		this.pedidoList = pedidoList;
	}

}
