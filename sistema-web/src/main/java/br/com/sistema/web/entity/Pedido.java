package br.com.sistema.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pedido")
public class Pedido extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -7771782473084528668L;

	@Enumerated(EnumType.STRING)
	@Column(name = "status_pedido")
	private StatusPedidoEnum statusPedido;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	@Temporal(TemporalType.DATE)
	@Column(name = "data", length = 10)
	private Date data;

	@Column(name = "valor_total", precision = 10)
	private BigDecimal valorTotal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido")
	private List<PedidoItem> pedidoItens = new ArrayList<PedidoItem>();

	/**
	 * @return the statusPedido
	 */
	public StatusPedidoEnum getStatusPedido() {
		return statusPedido;
	}

	/**
	 * @param statusPedido
	 *            the statusPedido to set
	 */
	public void setStatusPedido(StatusPedidoEnum statusPedido) {
		this.statusPedido = statusPedido;
	}

	/**
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario
	 *            the funcionario to set
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
	 * @return the valorTotal
	 */
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal
	 *            the valorTotal to set
	 */
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the pedidoItens
	 */
	public List<PedidoItem> getPedidoItens() {
		return pedidoItens;
	}

	/**
	 * @param pedidoItens
	 *            the pedidoItens to set
	 */
	public void setPedidoItens(List<PedidoItem> pedidoItens) {
		this.pedidoItens = pedidoItens;
	}

}
