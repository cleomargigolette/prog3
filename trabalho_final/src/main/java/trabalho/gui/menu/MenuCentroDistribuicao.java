package trabalho.gui.menu;

import trabalho.acoes.Acoes;
import trabalho.acoes.centrodistribuicao.AcoesCentroDistribuicaoAtualizar;
import trabalho.acoes.centrodistribuicao.AcoesCentroDistribuicaoDeletar;
import trabalho.acoes.centrodistribuicao.AcoesCentroDistribuicaoExibirDados;
import trabalho.acoes.centrodistribuicao.AcoesCentroDistribuicaoInserir;
import trabalho.acoes.centrodistribuicao.AcoesCentroDistribuicaoListarTodos;
import trabalho.acoes.centrodistribuicao.AcoesCentroDistribuicaoListarTodosPorFornecedor;
import trabalho.acoes.centrodistribuicao.AcoesCentroDistribuicaoListarTodosPorUF;

public class MenuCentroDistribuicao implements Menu {

	Acoes inserir = new AcoesCentroDistribuicaoInserir();
	Acoes exibirDados = new AcoesCentroDistribuicaoExibirDados();
	Acoes atualizar = new AcoesCentroDistribuicaoAtualizar();
	Acoes listarTodos = new AcoesCentroDistribuicaoListarTodos();
	Acoes deletar = new AcoesCentroDistribuicaoDeletar();
	Acoes listarTodosPorFornecedor = new AcoesCentroDistribuicaoListarTodosPorFornecedor();
	Acoes listarTodosPorUF  = new AcoesCentroDistribuicaoListarTodosPorUF();

	public void exibe() {

		System.out.println();
		System.out.println("CENTROS DE DISTRIBUIÇÃO");
		System.out.println("--- 1 - Inserir Centro de Distribuição");
		System.out.println("--- 2 - Exibir dados do Centro de Distribuição");
		System.out.println("--- 3 - Atualizar dados do Centro de Distribuição");
		System.out.println("--- 4 - Listar todos os Centros de Distribuição");
		System.out.println("--- 5 - Deletar Centro de Distribuição pelo ID");
		System.out.println("--- 6 - Listar Centros de Distribuição pelo id Fornecedor");
		System.out.println("--- 7 - Listar Centros de Distribuição pela UF");
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
			acaoSelecionada = listarTodosPorUF;
			break;
		default:
			acaoSelecionada = null;
			break;
		}

		if (acaoSelecionada != null)
			acaoSelecionada.executar();
	}

}
