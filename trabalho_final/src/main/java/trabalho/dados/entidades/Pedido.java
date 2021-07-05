/**
 * 
 */
package trabalho.dados.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author cleomar
 *
 */
@Entity
@Table(name="pedido")
public class Pedido {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="valor_total")
	private double valorTotal;
	
	@Column(name="data_reg")
	private LocalDate dataReg;
	
	@Column(name="cancelado")
	private boolean cancelado;
	
	@OneToMany(mappedBy="pedido",
			fetch = FetchType.LAZY,
			cascade={CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.PERSIST, CascadeType.REFRESH})
	private List<PedidoProduto> pedidosProdutos;
	
	public Pedido() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getDataReg() {
		return dataReg;
	}

	public void setDataReg(LocalDate dataReg) {
		this.dataReg = dataReg;
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}

	public List<PedidoProduto> getPedidosProdutos() {
		return pedidosProdutos;
	}

	public void setPedidosProdutos(List<PedidoProduto> pedidosProdutos) {
		this.pedidosProdutos = pedidosProdutos;
	}
	
	public void addPedidoProduto(PedidoProduto pedidoProduto) {
		
		if(pedidosProdutos == null) {
			
			pedidosProdutos = new ArrayList<>();
			
		}
		
		pedidosProdutos.add(pedidoProduto);
		
	}

}
