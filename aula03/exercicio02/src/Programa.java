
public class Programa {

	public static void main(String[] args) {
		
		TipoFuncionario tipo = new TipoFuncionario();
		tipo.setDescricao("Administrativo");
		tipo.setValorHora(38.7);
		
		Funcionario funcionario1 = new Funcionario();
		funcionario1.setNome("Matheus Santos");
		funcionario1.setId(1722761);
		funcionario1.setHorasSemanais(40);
		funcionario1.setTipo(tipo);
		
		Funcionario funcionario2 = new Funcionario();
		funcionario2.setNome("Juliana Nogueira");
		funcionario2.setId(87625142);
		funcionario2.setHorasSemanais(30);
		funcionario2.setTipo(tipo);

		Funcionario funcionario3 = new Funcionario();
		funcionario3.setNome("João Ferreira");
		funcionario3.setId(1722761);
		funcionario3.setHorasSemanais(40);
		funcionario3.setTipo(tipo);
		
		System.out.println(funcionario1.salario());
		System.out.println(funcionario2.salario());
		System.out.println(funcionario3.salario());
		
		CalculadoraSalarios calculadora = new CalculadoraSalarios();
		calculadora.adicionar(funcionario1);
		calculadora.adicionar(funcionario2);
		calculadora.adicionar(funcionario3);
		
		System.out.println(calculadora.obterTotalSalarios());
		System.out.println(calculadora.obterMediaSalarios());

	}

}
