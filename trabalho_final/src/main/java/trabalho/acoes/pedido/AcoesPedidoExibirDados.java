/**
 * 
 */
package trabalho.acoes.pedido;

import java.time.format.DateTimeFormatter;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.PedidoDAO;
import trabalho.dados.entidades.Pedido;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesPedidoExibirDados implements Acoes {

	@Override
	public void executar() {
		
		Teclado teclado = new Teclado();
		PedidoDAO pedidoDAO = new PedidoDAO();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("--- Informe o id do Pedido que deseja exibir dados:");
		int id = teclado.leInt();
		
		Pedido pedido = pedidoDAO.obter(id);
		
		if(pedido == null) {
			
			System.out.println("--- O Pedido com este id não foi encontrado.");
			
		}else {
			
			String ativo = pedido.isCancelado() ? "Sim" : "Não";
			String dataRegFormatada = pedido.getDataReg().format(formatter);
			
			System.out.println();
			System.out.println("--- Id: " + pedido.getId());
			System.out.println("--- Data de Registro: " + dataRegFormatada);
			System.out.println("--- Total do Pedido: " + pedido.getValorTotal());
			System.out.println("--- Cancelado: " + ativo);
			System.out.println();
			
			this.printItensPedido(pedido);
			
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
