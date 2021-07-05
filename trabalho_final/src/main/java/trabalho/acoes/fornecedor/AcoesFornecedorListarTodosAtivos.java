/**
 * 
 */
package trabalho.acoes.fornecedor;

import java.util.List;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.FornecedorDAO;
import trabalho.dados.entidades.Fornecedor;

/**
 * @author cleomar
 *
 */
public class AcoesFornecedorListarTodosAtivos implements Acoes {

	@Override
	public void executar() {
		
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		
		List<Fornecedor> fornecedores = fornecedorDAO.obterTodosAtivos();
		
		if(fornecedores.isEmpty() == true) {
			
			System.out.println("--- No momento não há fornecedores cadastrados Ativos.");
			
		}else {
			
			fornecedores.forEach(fornecedor -> {
				
				System.out.println("");
				System.out.println("--- Id: " + fornecedor.getId());
				System.out.println("--- Nome: " + fornecedor.getNome());
				System.out.println("");
				System.out.println("--- ###############################################################");
				
			});
		}
	}

}
