
public class Funcionario implements Salariavel{

	private int id;
	private String nome;
	private double horasSemanais;
	private TipoFuncionario tipo;
	
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

	public double getHorasSemanais() {
		return horasSemanais;
	}

	public void setHorasSemanais(double horasSemanais) {
		this.horasSemanais = horasSemanais;
	}

	public TipoFuncionario getTipo() {
		return tipo;
	}

	public void setTipo(TipoFuncionario tipo) {
		this.tipo = tipo;
	}

	@Override
	public double salario() {
		double salario = this.horasSemanais * tipo.getValorHora() * 5;
		return salario;
	}
	
}
