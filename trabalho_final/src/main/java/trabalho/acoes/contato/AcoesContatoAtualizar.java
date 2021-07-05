/**
 * 
 */
package trabalho.acoes.contato;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.ContatoDAO;
import trabalho.dados.entidades.Contato;
import trabalho.dominio.TipoContato;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesContatoAtualizar implements Acoes {

	@Override
	public void executar() {

		Teclado teclado = new Teclado();
		ContatoDAO contatoDAO = new ContatoDAO();

		System.out.println();

		System.out.println("--- Informe o id do Centro de Distribuicao que deseja atualizar:");
		int id = teclado.leInt();

		Contato contato = contatoDAO.obter(id);

		if (contato == null) {

			System.out.println("--- O Contato com este id não foi encontrado.");

		} else {

			contato.setTipo(this.populaContato(teclado));
			
			System.out.println("--- Informe a descrição do Contato:");
			contato.setDescricao(teclado.leString());

			boolean atualizou = contatoDAO.atualiza(contato);

			String print = atualizou ? "--- Contato foi atualizado com sucesso!" : "--- O Contato não foi atualizado!";

			System.out.println(print);

		}

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
