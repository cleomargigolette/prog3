package trabalho.dados.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author cleomar
 *
 */
@Entity
@Table(name="produto")
public class Produto {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="valor")
	private double valor;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="codigo_barras")
	private String codigoBarras;
	
	@Column(name="total_estoque")
	private int totalEstoque;
	
	@Column(name="ativo")
	private boolean ativo;
	
	@ManyToOne(fetch = FetchType.LAZY,
			cascade={CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="fornecedor_id")
	private Fornecedor fornecedor;
	
	@OneToMany(mappedBy="produto",
			fetch = FetchType.LAZY,
			cascade={CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.PERSIST, CascadeType.REFRESH})
	private List<PedidoProduto> pedidosProdutos;
	
	public Produto() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public double getValor() {
		return valor;
	}

	public void setId(double valor) {
		this.valor = valor;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setAtivo(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public int getTotalEstoque() {
		return totalEstoque;
	}

	public void setTotalEstoque(int totalEstoque) {
		this.totalEstoque = totalEstoque;
	}

	public List<PedidoProduto> getPedidosProdutos() {
		return pedidosProdutos;
	}

	public void setPedidosProdutos(List<PedidoProduto> pedidosProdutos) {
		this.pedidosProdutos = pedidosProdutos;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public void addPedidoProduto(PedidoProduto pedidoProduto) {
		
		if(pedidosProdutos == null) {
			
			pedidosProdutos = new ArrayList<>();
			
		}
		
		pedidosProdutos.add(pedidoProduto);
		
	}
}
