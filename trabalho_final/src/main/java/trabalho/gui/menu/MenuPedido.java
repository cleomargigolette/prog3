/**
 * 
 */
package trabalho.gui.menu;

import trabalho.acoes.Acoes;
import trabalho.acoes.pedido.AcoesPedidoAtualizar;
import trabalho.acoes.pedido.AcoesPedidoCancelar;
import trabalho.acoes.pedido.AcoesPedidoDeletar;
import trabalho.acoes.pedido.AcoesPedidoExibirDados;
import trabalho.acoes.pedido.AcoesPedidoInserir;
import trabalho.acoes.pedido.AcoesPedidoListarTodos;
import trabalho.acoes.pedido.AcoesValorTotalDosPedidos;

/**
 * @author cleomar
 *
 */
public class MenuPedido implements Menu {

	Acoes inserir = new AcoesPedidoInserir();
	Acoes exibirDados = new AcoesPedidoExibirDados();
	Acoes atualizar = new AcoesPedidoAtualizar();
	Acoes listarTodos = new AcoesPedidoListarTodos();
	Acoes deletar = new AcoesPedidoDeletar();
	Acoes cancelar = new AcoesPedidoCancelar();
	Acoes valorTotalDosPedidos = new AcoesValorTotalDosPedidos();
	
	public void exibe() {

		System.out.println();
		System.out.println("Pedidos");
		System.out.println("--- 1 - Inserir Pedidos");
		System.out.println("--- 2 - Exibir dados do Pedido");
		System.out.println("--- 3 - Atualizar dados do Pedido");
		System.out.println("--- 4 - Listar todos os Pedidos");
		System.out.println("--- 5 - Deletar Pedido pelo ID");
		System.out.println("--- 6 - Cancelar Pedido pelo ID");
		System.out.println("--- 7 - Buscar Valor total dos pedidos");
		System.out.println();                        
	}

	public void executarOpcao(int opcao) {
                   
		Acoes acaoSelecionada = null;

		switch (opcao) {
		case 1:
			acaoSelecionada = inserir;
			break;
		case 2:
			acaoSelecionada = exibirDados;
			break;
		case 3:
			acaoSelecionada = atualizar;
			break;
		case 4:
			acaoSelecionada = listarTodos;
			break;
		case 5:
			acaoSelecionada = deletar;
			break;
		case 6:
			acaoSelecionada = cancelar;
			break;
		case 7:
			acaoSelecionada = valorTotalDosPedidos;
			break;
		default:
			acaoSelecionada = null;
			break;
		}

		if (acaoSelecionada != null)
			acaoSelecionada.executar();
	}
}
