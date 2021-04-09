import java.util.ArrayList;

public class CalculadoraSalarios {

	private ArrayList<Salariavel> salariaveis;
	
	public CalculadoraSalarios() {
		salariaveis = new ArrayList<Salariavel>();
	}

	public ArrayList<Salariavel> getSalariaveis() {
		return salariaveis;
	}
	
	public void adicionar(Salariavel salariavel) {
		this.salariaveis.add(salariavel);
	}
	
	public double obterTotalSalarios() {
		double somatorio = 0;
		for (int i = 0; i < salariaveis.size(); i++) {
			somatorio += salariaveis.get(i).salario();
		}
		return somatorio;
	}
	
	public double obterMediaSalarios() {
		double somatorio = obterTotalSalarios();
		double media = somatorio / salariaveis.size();
		return media;
	}
	
}
