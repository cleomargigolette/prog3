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
public class AcoesFornecedoListarTodos implements Acoes{

	@Override
	public void executar() {
		
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		
		List<Fornecedor> fornecedores = fornecedorDAO.obterTodos();
		
		if(fornecedores.isEmpty() == true) {
			
			System.out.println("--- No momento não há fornecedores cadastrados.");
			
		}else {
			
			fornecedores.forEach(fornecedor -> {
				
				String ativo = fornecedor.getAtivo() ? "Sim" : "Não";
				
				System.out.println("");
				System.out.println("--- Id: " + fornecedor.getId());
				System.out.println("--- Nome: " + fornecedor.getNome());
				System.out.println("--- Ativo: " + ativo);
				System.out.println("");
				System.out.println("--- ###############################################################");
				
			});
		}
	}

}
