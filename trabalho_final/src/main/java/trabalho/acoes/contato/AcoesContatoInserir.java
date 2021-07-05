/**
 * 
 */
package trabalho.acoes.contato;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.ContatoDAO;
import trabalho.dados.dao.FornecedorDAO;
import trabalho.dados.entidades.Contato;
import trabalho.dados.entidades.Fornecedor;
import trabalho.dominio.TipoContato;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesContatoInserir implements Acoes {

	@Override
	public void executar() {

		Teclado teclado = new Teclado();
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		ContatoDAO contatoDAO = new ContatoDAO();
		Contato contato = new Contato();

		boolean fornecedorInvalido = true;

		do {

			System.out.println("--- Informe o id do Fornecedor desse Contato:");
			Integer idForncedor = Integer.valueOf(teclado.leString());

			Fornecedor fornecedor = fornecedorDAO.obter(idForncedor);

			if (fornecedor != null) {

				contato.setFornecedor(fornecedor);
				
				contato.setTipo(this.populaContato(teclado));
				
				System.out.println("--- Informe a descrição do Contato:");
				contato.setDescricao(teclado.leString());

				contato.setAtivo(true);

				boolean inseriu = contatoDAO.insere(contato);

				String print = inseriu ? "--- Contato inserido com sucesso!" : "--- O novo Contato não foi inserido!";
				
				System.out.println(print);
				
				fornecedorInvalido = false;

			} else {
				System.out.println("-------------------------------------------------");
				System.out.println("--- O Fornecedor com este id não foi encontrado.");
				System.out.println("--- Vamos tentar novamente");
				System.out.println("-------------------------------------------------");
			}

		} while (fornecedorInvalido);

	}
	
	private TipoContato populaContato(Teclado teclado) {
		
		boolean tipoValido = true;
		TipoContato tipoContato = null;
		
		do {
			
			System.out.println("--- Informe a Tipo de Contato:");
			System.out.println("--- Email = 1");
			System.out.println("--- Telefone = 2");
			int tipo = teclado.leInt();
			
			if(tipo != 1 && tipo != 2) {
				
				System.out.println();
				System.out.println("--- Opção inválida");
				System.out.println("--- Vamos tentar de novo");
				System.out.println();
				System.out.println("--------------------------------------");
				
			}else {
				
				tipoContato = tipo == 1 ? TipoContato.EMAIL : TipoContato.PHONE;
				
				tipoValido = false;
			}
								
		} while(tipoValido);
		
		return tipoContato;
		
	}
}
