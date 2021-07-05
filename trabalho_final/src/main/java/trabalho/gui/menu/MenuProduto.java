/**
 * 
 */
package trabalho.gui.menu;

import trabalho.acoes.Acoes;
import trabalho.acoes.produto.AcoesProdutoAtualizar;
import trabalho.acoes.produto.AcoesProdutoDeletar;
import trabalho.acoes.produto.AcoesProdutoExibirDados;
import trabalho.acoes.produto.AcoesProdutoInserir;
import trabalho.acoes.produto.AcoesProdutoListarTodos;
import trabalho.acoes.produto.AcoesProdutoListarTodosPorFornecedor;
import trabalho.acoes.produto.AcoesProdutoListarValorAcima50;

/**
 * @author cleomar
 *
 */
public class MenuProduto implements Menu {

	Acoes inserir = new AcoesProdutoInserir();
	Acoes exibirDados = new AcoesProdutoExibirDados();
	Acoes atualizar = new AcoesProdutoAtualizar();
	Acoes listarTodos = new AcoesProdutoListarTodos();
	Acoes deletar = new AcoesProdutoDeletar();
	Acoes listarTodosPorFornecedor = new AcoesProdutoListarTodosPorFornecedor();
	Acoes listarProdutosValorAcima50 = new AcoesProdutoListarValorAcima50();
	
	public void exibe() {

		System.out.println();
		System.out.println("PRODUTOS");
		System.out.println("--- 1 - Inserir Produto");
		System.out.println("--- 2 - Exibir dados do Produto");
		System.out.println("--- 3 - Atualizar dados do Produto");
		System.out.println("--- 4 - Listar todos os Produtos");
		System.out.println("--- 5 - Deletar Produto pelo ID");
		System.out.println("--- 6 - Listar Produtos pelo id Fornecedor");
		System.out.println("--- 7 - Listar Produtos com valor acima de R$50,00");
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
			acaoSelecionada = listarTodosPorFornecedor;
			break;
		case 7:
			acaoSelecionada = listarProdutosValorAcima50;
			break;
		default:
			acaoSelecionada = null;
			break;
		}

		if (acaoSelecionada != null)
			acaoSelecionada.executar();
	}

}
