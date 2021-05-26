package database.entities;

public class Conta {

	private long id;
	private String numero;
	private double saldo;
	private double limite;
	private long idPessoaFisica;
	private long idagencia;
	private long idgerente;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public double getLimite() {
		return limite;
	}
	
	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	public long getIdPessoaFisica() {
		return idPessoaFisica;
	}
	
	public void setIdPessoaFisica(long idPessoaFisica) {
		this.idPessoaFisica = idPessoaFisica;
	}
	
	public long getIdagencia() {
		return idagencia;
	}
	
	public void setIdagencia(long idagencia) {
		this.idagencia = idagencia;
	}
	
	public long getIdgerente() {
		return idgerente;
	}
	
	public void setIdgerente(long idgerente) {
		this.idgerente = idgerente;
	}
	
}
