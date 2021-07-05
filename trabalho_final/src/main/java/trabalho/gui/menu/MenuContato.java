/**
 * 
 */
package trabalho.gui.menu;

import trabalho.acoes.Acoes;
import trabalho.acoes.contato.AcoesContatoAtualizar;
import trabalho.acoes.contato.AcoesContatoDeletar;
import trabalho.acoes.contato.AcoesContatoExibirDados;
import trabalho.acoes.contato.AcoesContatoInserir;
import trabalho.acoes.contato.AcoesContatoListarTodos;
import trabalho.acoes.contato.AcoesContatoListarTodosPorFornecedor;
import trabalho.acoes.contato.AcoesContatoListarTodosPorTipo;

/**
 * @author cleomar
 *
 */
public class MenuContato implements Menu{
	
	Acoes inserir = new AcoesContatoInserir();
	Acoes exibirDados = new AcoesContatoExibirDados();
	Acoes atualizar = new AcoesContatoAtualizar();
	Acoes listarTodos = new AcoesContatoListarTodos();
	Acoes deletar = new AcoesContatoDeletar();
	Acoes listarTodosPorFornecedor = new AcoesContatoListarTodosPorFornecedor();
	Acoes listarTodosPorTipo = new AcoesContatoListarTodosPorTipo();

	public void exibe() {

		System.out.println();
		System.out.println("CONTATOS DE FORNECEDORES");
		System.out.println("--- 1 - Inserir Contato");
		System.out.println("--- 2 - Exibir dados do Contato");
		System.out.println("--- 3 - Atualizar dados do Contato");
		System.out.println("--- 4 - Listar todos os Contato");
		System.out.println("--- 5 - Deletar Contato pelo ID");
		System.out.println("--- 6 - Listar Contato pelo id Fornecedor");
		System.out.println("--- 7 - Listar Contato pelo tipo");
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
			acaoSelecionada = listarTodosPorTipo;
			break;
		default:
			acaoSelecionada = null;
			break;
		}

		if (acaoSelecionada != null)
			acaoSelecionada.executar();
	}

}
