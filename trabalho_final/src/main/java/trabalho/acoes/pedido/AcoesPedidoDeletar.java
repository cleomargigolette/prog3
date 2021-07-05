/**
 * 
 */
package trabalho.acoes.pedido;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.PedidoDAO;
import trabalho.dados.dao.PedidoProdutoDAO;
import trabalho.dados.entidades.Pedido;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesPedidoDeletar implements Acoes {

	@Override
	public void executar() {
		
		Teclado teclado = new Teclado();
		PedidoDAO pedidoDAO = new PedidoDAO();
		PedidoProdutoDAO pedidoProdutoDAO = new PedidoProdutoDAO();
		
		System.out.println("--- Informe o ID do Pedido:");
		Pedido pedido = pedidoDAO.obter(teclado.leInt());
	 	
	 	if(pedido == null) {
	 		
	 		System.out.println("--- O Pedido com este id não foi encontrado.");
	 		
	 	}else {
	 		
	 		pedido.getPedidosProdutos().forEach(item -> {
	 			pedidoProdutoDAO.deleta(item);
	 		});
	 		
	 		boolean deleted = pedidoDAO.deleta(pedido);
	 		
	 		String print = deleted ? "--- Pedido foi deletetado com sucesso!" : "--- O Fornecedor não foi deletetado!";
	 		
			System.out.println(print);
			
	 	}
	}
}
