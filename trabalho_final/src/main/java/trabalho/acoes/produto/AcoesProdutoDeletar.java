/**
 * 
 */
package trabalho.acoes.produto;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.ProdutoDAO;
import trabalho.dados.entidades.Produto;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesProdutoDeletar implements Acoes {

	@Override
	public void executar() {
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Teclado teclado = new Teclado();
		
		System.out.println("--- Informe o ID do Produto:");
		Produto produto = produtoDAO.obter(teclado.leInt());
	 	
	 	if(produto == null) {
	 		
	 		System.out.println("--- O Produto com este id não foi encontrado.");
	 		
	 	}else {
	 		
	 		boolean deleted = produtoDAO.deleta(produto);
	 		
	 		String print = deleted ? "--- Produto foi deletetado com sucesso!" : "--- O Produto não foi deletetado!";
	 		
			System.out.println(print);
			
	 	}       

	}

}
