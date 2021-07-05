/**
 * 
 */
package trabalho.acoes.pedido;

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
public class AcoesPedidoAtualizar implements Acoes {

	@Override
	public void executar() {
		
		Teclado teclado = new Teclado();
		PedidoDAO pedidoDAO = new PedidoDAO();

		System.out.println();

		System.out.println("--- Informe o id do pedido que deseja atualizar:");
		int id = teclado.leInt();

		Pedido pedido = pedidoDAO.obter(id);
		String status = "";

		if (pedido == null) {

			System.out.println("--- O pedido com este id não foi encontrado.");

		} else {
			
			boolean opcaoInvalida = true;
			
			do {
				System.out.println("---");
				System.out.println("--- Você deseja adicionar ou deletar itens?");
				System.out.println("--- Adionar = 1");
				System.out.println("--- Deletar = 2");
				System.out.println("---");
				int opcao = teclado.leInt();
				
				switch (opcao) {
				case 1:
					
					status = this.adicionarItem(pedido, teclado) ? "--- Pedido atualizado com sucesso!" : "--- O Pedido não foi atualizado!";
					
					System.out.println("---- " + status);
					
					opcaoInvalida = false;
					
					break;
				case 2:
					
					status = this.deletarItem(pedido, teclado) ? "--- Pedido atualizado com sucesso!" : "--- O Pedido não foi atualizado!";
					
					System.out.println("---- " + status);
					
					opcaoInvalida = false;
					
					break;

				default:
					System.out.println("--- Opção inválida vamos tentar novamente");
					break;
				}
				
			} while(opcaoInvalida);
			
		}

	}
	
	private boolean adicionarItem(Pedido pedido, Teclado teclado) {
		
		boolean itemAdd = true;
		double totalPedido = pedido.getValorTotal();
		PedidoProdutoDAO pedidoProdutoDAO = new PedidoProdutoDAO();
		PedidoDAO pedidoDAO = new PedidoDAO();
		
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
		
		pedido.setValorTotal(totalPedido);
		
		return pedidoDAO.atualiza(pedido);
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
	
	private boolean deletarItem(Pedido pedido, Teclado teclado) {
		
		PedidoProdutoDAO pedidoProdutoDAO = new PedidoProdutoDAO();
		PedidoDAO pedidoDAO = new PedidoDAO();
		
		System.out.println("--- **** Esses são os itens do Pedido");
		
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
		
		System.out.println("--- **** Insira o id do item que deseja excluir:");
		int idItem = teclado.leInt();
		
		PedidoProduto pedidoProduto = pedidoProdutoDAO.obter(idItem);
		
		if(pedidoProduto != null) {
			
			pedido.setValorTotal(pedido.getValorTotal() - pedidoProduto.getValorTotalProduto());
			
			pedidoDAO.atualiza(pedido);
			
			return pedidoProdutoDAO.deleta(pedidoProduto);

		}else {
			
			System.out.println("--- **** Esse Pedido não contém itens com esse id.");
			
			return false;
		}	
		
	}

}
