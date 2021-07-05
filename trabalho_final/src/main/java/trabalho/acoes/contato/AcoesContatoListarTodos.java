/**
 * 
 */
package trabalho.acoes.contato;

import java.util.List;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.ContatoDAO;
import trabalho.dados.entidades.Contato;

/**
 * @author cleomar
 *
 */
public class AcoesContatoListarTodos implements Acoes {

	@Override
	public void executar() {
		
		ContatoDAO contatoDAO = new ContatoDAO();
		
		List<Contato> contatos = contatoDAO.obterTodos();
		
		if(contatos.isEmpty() == true) {
			
			System.out.println("--- No momento não há Contatos cadastrados.");
			
		}else {
			
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
		}
	}

}
