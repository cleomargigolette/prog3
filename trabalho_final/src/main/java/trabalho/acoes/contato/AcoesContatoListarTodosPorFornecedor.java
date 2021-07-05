/**
 * 
 */
package trabalho.acoes.contato;

import java.util.List;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.FornecedorDAO;
import trabalho.dados.entidades.Contato;
import trabalho.dados.entidades.Fornecedor;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesContatoListarTodosPorFornecedor implements Acoes {

	@Override
	public void executar() {
		
		Teclado teclado = new Teclado();
		FornecedorDAO fornecedorDAO = new FornecedorDAO();

		boolean fornecedorInvalido = true;

		do {

			System.out.println("--- Informe o id do Fornecedor desse Centro de Distribuição:");
			Integer idForncedor = Integer.valueOf(teclado.leString());

			Fornecedor fornecedor = fornecedorDAO.obter(idForncedor);

			if (fornecedor != null) {
				
				this.printListaContatos(fornecedor.getContatos());
				
				fornecedorInvalido = false;

			} else {
				
				System.out.println("-------------------------------------------------");
				System.out.println("--- O Fornecedor com este id não foi encontrado.");
				System.out.println("--- Vamos tentar novamente");
				System.out.println("-------------------------------------------------");
			}

		} while (fornecedorInvalido);

	}
	
	private void printListaContatos(List<Contato> contatos) {
		
		if(contatos.isEmpty() == false) {
			
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
			
		}else {
			
			System.out.println("");
			System.out.println();
			System.out.println("--- Opss, esse Fornecedor não possui centros de distribuição cadastrado." );
			System.out.println("");
			System.out.println("--- ###############################################################");
			
		}
		
	}
}
