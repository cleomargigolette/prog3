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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author cleomar
 *
 */
@Entity
@Table(name="fornecedor")
public class Fornecedor {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="ativo")
	private boolean ativo;
	
	@OneToMany(mappedBy="fornecedor",
			fetch = FetchType.LAZY,
			cascade={CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Produto> produtos;
	
	@OneToMany(mappedBy="fornecedor",
			fetch = FetchType.LAZY,
			cascade={CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Contato> contatos;
	
	@OneToMany(mappedBy="fornecedor",
			fetch = FetchType.LAZY,
			cascade={CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.PERSIST, CascadeType.REFRESH})
	private List<CentroDistribuicao> centrosDistribuicao;
	
	public Fornecedor() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public List<CentroDistribuicao> getCentrosDistribuicao() {
		return centrosDistribuicao;
	}

	public void setCentrosDistribuicao(List<CentroDistribuicao> centrosDistribuicao) {
		this.centrosDistribuicao = centrosDistribuicao;
	}

	public void addProduto(Produto produto) {
		
		if(produtos == null) {
			
			produtos = new ArrayList<>();
			
		}
		
		produtos.add(produto);
		
	}
	
	public void addContato(Contato contato) {
		
		if(contatos == null) {
			
			contatos = new ArrayList<>();
			
		}
		
		contatos.add(contato);
		
	}
	
	public void addCentroDistribuicao(CentroDistribuicao centroDistribuicao) {
		
		if(centrosDistribuicao == null) {
			
			centrosDistribuicao = new ArrayList<>();
			
		}
		
		centrosDistribuicao.add(centroDistribuicao);
		
	}
	
}
