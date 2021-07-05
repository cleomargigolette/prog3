/**
 * 
 */
package trabalho.acoes.pedido;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.PedidoDAO;

/**
 * @author cleomar
 *
 */
public class AcoesValorTotalDosPedidos implements Acoes {

	@Override
	public void executar() {
		
		PedidoDAO pedidoDAO = new PedidoDAO(); 
		
		double valorMensal = pedidoDAO.valorTotalDosPedidos();
		
		System.out.println("---- O valor total dos pedidos foram R$" + valorMensal);

	}

}
