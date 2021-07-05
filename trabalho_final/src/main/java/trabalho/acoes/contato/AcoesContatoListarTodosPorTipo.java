/**
 * 
 */
package trabalho.acoes.contato;

import java.util.List;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.ContatoDAO;
import trabalho.dados.entidades.Contato;
import trabalho.dominio.TipoContato;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesContatoListarTodosPorTipo implements Acoes{
	
	@Override
	public void executar() {
		
		Teclado teclado = new Teclado();
		ContatoDAO contatoDAO = new ContatoDAO();
		
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

		List<Contato> contatos = contatoDAO.listarPorTipo(tipoContato);

		this.printListaContatos(contatos);

	}

	private void printListaContatos(List<Contato> contatos) {

		if (contatos.isEmpty() == false) {

			contatos.forEach(contato -> {

				String ativo = contato.isAtivo() ? "Sim" : "Não";

				System.out.println("");
				System.out.println();
				System.out.println("--- Id: " + contato.getId());
				System.out.println("--- Tipo: " + contato.getTipo());
				System.out.println("--- Descrição: " + contato.getDescricao());
				System.out.println("--- Nome do Fornecedor: " + contato.getFornecedor().getNome());
				System.out.println("--- Ativo: " + ativo);
				System.out.println("");
				System.out.println("--- ###############################################################");

			});

		} else {

			System.out.println("");
			System.out.println();
			System.out.println("--- Opss, não tem Contatos desse tipo na base de dados");
			System.out.println("");
			System.out.println("--- ###############################################################");

		}
	}

}
