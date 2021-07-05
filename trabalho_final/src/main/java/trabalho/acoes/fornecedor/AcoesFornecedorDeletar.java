/**
 * 
 */
package trabalho.acoes.fornecedor;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.FornecedorDAO;
import trabalho.dados.entidades.Fornecedor;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesFornecedorDeletar implements Acoes {

	@Override
	public void executar() {
		
		Teclado teclado = new Teclado();
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		
		System.out.println("--- Informe o ID do Fornecedor:");
	 	Fornecedor fornecedor = fornecedorDAO.obter(teclado.leInt());
	 	
	 	if(fornecedor == null) {
	 		
	 		System.out.println("--- O Fornecedor com este id não foi encontrado.");
	 		
	 	}else {
	 		
	 		boolean deleted = fornecedorDAO.deleta(fornecedor);
	 		
	 		String print = deleted ? "--- Fornecedor foi deletetado com sucesso!" : "--- O Fornecedor não foi deletetado!";
	 		
			System.out.println(print);
			
	 	}
		
	}

}
