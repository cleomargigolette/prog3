/**
 * 
 */
package trabalho.acoes.pedido;

import java.time.format.DateTimeFormatter;
import java.util.List;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.PedidoDAO;
import trabalho.dados.entidades.Pedido;

/**
 * @author cleomar
 *
 */
public class AcoesPedidoListarTodos implements Acoes {

	@Override
	public void executar() {
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		List<Pedido> pedidos = pedidoDAO.obterTodos();
		
		if(pedidos.isEmpty() == true) {
			
			System.out.println("--- Não foram encontrados na base de dados pedidos");
			
		}else {
			
			pedidos.forEach(pedido -> {
				
				String ativo = pedido.isCancelado() ? "Sim" : "Não";
				String dataRegFormatada = pedido.getDataReg().format(formatter);
				
				System.out.println("---------------------------------------------------------");
				System.out.println("--- PEDIDO");
				System.out.println("--- Id: " + pedido.getId());
				System.out.println("--- Data de Registro: " + dataRegFormatada);
				System.out.println("--- Total do Pedido: " + pedido.getValorTotal());
				System.out.println("--- Cancelado: " + ativo);
				System.out.println();
				
				this.printItensPedido(pedido);
			});
			
		}

	}
	
	private void printItensPedido(Pedido pedido) {
		
		for (int index = 0; index < pedido.getPedidosProdutos().size(); index++) {
			
			System.out.println("--- **** Item número: " + index);
			System.out.println();
			System.out.println("--- **** Id: " + pedido.getPedidosProdutos().get(index).getId());
			System.out.println("--- **** Nome do Produto: " + pedido.getPedidosProdutos().get(index).getProduto().getNome());
			System.out.println("--- **** Valor Unitário Produto: " + pedido.getPedidosProdutos().get(index).getValorUnitarioProduto());
			System.out.println("--- **** Quantidade total de produtos: " + pedido.getPedidosProdutos().get(index).getQuantidadeTotal());
			System.out.println("--- **** Valor Total do Item: " + pedido.getPedidosProdutos().get(index).getValorTotalProduto());
			System.out.println();
			System.out.println();
		}
	}

}
