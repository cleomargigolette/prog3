/**
 * 
 */
package trabalho.acoes.pedido;

import java.time.LocalDate;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.PedidoDAO;
import trabalho.dados.dao.PedidoProdutoDAO;
import trabalho.dados.dao.ProdutoDAO;
import trabalho.dados.entidades.Pedido;
import trabalho.dados.entidades.PedidoProduto;
import trabalho.dados.entidades.Produto;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesPedidoInserir implements Acoes {

	@Override
	public void executar() {

		Teclado teclado = new Teclado();

		PedidoProdutoDAO pedidoProdutoDAO = new PedidoProdutoDAO();
		
		Pedido pedido = this.criarNovoPedido();
		boolean itemAdd = true;
		double totalPedido = 0;
		
		if(pedido != null) {
			
			do {
				PedidoProduto pedidoProduto = new PedidoProduto();
				
				Produto produto = this.obterProduto();
				
				System.out.println("--- Informe a quantidade de Produtos:");
				int quantidadeProduto = (teclado.leInt());
				
				double valorUnitario = produto.getValor();
				double valorTotalItem = valorUnitario * quantidadeProduto;

				pedidoProduto.setProduto(produto);
				pedidoProduto.setPedido(pedido);
				pedidoProduto.setValorUnitarioProduto(valorUnitario);
				pedidoProduto.setValorTotalProduto(valorTotalItem);
				pedidoProduto.setQuantidadeTotal(quantidadeProduto);
				totalPedido = totalPedido + valorTotalItem;

				pedidoProdutoDAO.insere(pedidoProduto);
				
				itemAdd = this.verificaSeAdicionaMaisUmItem();

			} while (itemAdd);
		}
		
		String print = this.calcValorTotalPedido(pedido, totalPedido)? "--- Pedido inserido com sucesso!" : "--- O novo Pedido não foi inserido!";

		System.out.println(print);

	}
	
	private boolean verificaSeAdicionaMaisUmItem() {
		
		Teclado teclado = new Teclado();
		
		boolean addItemValido = true;
		int addItem = 1;
		
		do {
		
			System.out.println("--------------------------");
			System.out.println("--- Adicionar novo item:");
			System.out.println("--- Sim = Digite 1");
			System.out.println("--- Não = Digite 2");
			System.out.println("--------------------------");
			addItem = (teclado.leInt());
			
			if(addItem != 1 && addItem != 2) {
				
				System.out.println("--- --------------------------------------");
				System.out.println("--- Opção inválida, vamos tentar de novo");
				System.out.println("--- ---------------------------------------");
				
			}else {
				addItemValido = false;
			}
		
		} while (addItemValido);
		
		
		return addItem != 1 ? false : true;
	}
	
	private Pedido criarNovoPedido() {
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		
		Pedido pedido = new Pedido();

		pedido.setDataReg(LocalDate.now());
		pedido.setCancelado(false);

		return pedidoDAO.insere(pedido) ? pedido : null;
	}
	
	private Produto obterProduto() {
		
		Produto produto = null;
		boolean produtoIsNull = true;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Teclado teclado = new Teclado();
		
		do {
			
			System.out.println("--------------------------");
			System.out.println("--- Informe ID do Produto:");
			int idProduto = (teclado.leInt());

			produto = produtoDAO.obter(idProduto);
			
			if(produto != null) {
				
				produtoIsNull = false;
			}else {
				
				System.out.println("---------------------------------------");
				System.out.println("--- Produto com esse id não encontrado");
				System.out.println("--- Vamos tentar de novo");
				System.out.println("---------------------------------------");
			}

		} while (produtoIsNull);
		
		return produto;
		
	}
	
	private boolean calcValorTotalPedido(Pedido pedido, double totalPedido) {
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		
		pedido.setValorTotal(totalPedido);
		
		return pedidoDAO.atualiza(pedido);
		
	}

}
