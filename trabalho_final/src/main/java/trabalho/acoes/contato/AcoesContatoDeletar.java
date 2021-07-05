/**
 * 
 */
package trabalho.acoes.contato;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.ContatoDAO;
import trabalho.dados.entidades.Contato;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesContatoDeletar implements Acoes {

	@Override
	public void executar() {
		
		ContatoDAO contatoDAO = new ContatoDAO();
		Teclado teclado = new Teclado();
		
		System.out.println("--- Informe o ID do Centro de Distribuicao:");
		Contato contato = contatoDAO.obter(teclado.leInt());
	 	
	 	if(contato == null) {
	 		
	 		System.out.println("--- O Contato com este id não foi encontrado.");
	 		
	 	}else {
	 		
	 		boolean deleted = contatoDAO.deleta(contato);
	 		
	 		String print = deleted ? "--- Contato foi deletetado com sucesso!" : "--- O Contato não foi deletetado!";
	 		
			System.out.println(print);
			
	 	}    
	}

}
