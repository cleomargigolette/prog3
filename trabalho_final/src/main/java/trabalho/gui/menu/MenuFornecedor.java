package trabalho.gui.menu;

import trabalho.acoes.Acoes;
import trabalho.acoes.fornecedor.AcoesFornecedorExibirDados;
import trabalho.acoes.fornecedor.AcoesFornecedorAtivarDesativar;
import trabalho.acoes.fornecedor.AcoesFornecedorDeletar;
import trabalho.acoes.fornecedor.AcoesFornecedorAtualizar;
import trabalho.acoes.fornecedor.AcoesFornecedorInserir;
import trabalho.acoes.fornecedor.AcoesFornecedoListarTodos;
import trabalho.acoes.fornecedor.AcoesFornecedorListarTodosAtivos;

public class MenuFornecedor implements Menu{

	Acoes inserir = new AcoesFornecedorInserir();
	Acoes exibirDados = new AcoesFornecedorExibirDados();
	Acoes atualizar = new AcoesFornecedorAtualizar();
	Acoes listarTodos =  new AcoesFornecedoListarTodos();
	Acoes listarTodosAtivos =  new AcoesFornecedorListarTodosAtivos();
	Acoes deletar =  new AcoesFornecedorDeletar();
	Acoes ativarDesativar =  new AcoesFornecedorAtivarDesativar();

	public void exibe() {
		
		System.out.println("");
		System.out.println("--- FORNECEDOR");
		System.out.println("--- 1 - Inserir");
		System.out.println("--- 2 - Exibir dados Fornecedor");
		System.out.println("--- 3 - Atualizar dados Fornecedor");
		System.out.println("--- 4 - Listar todos os Fornecedores");
		System.out.println("--- 5 - Listar todos os Fornecedores Ativos");
		System.out.println("--- 6 - Deletar Fornecedor pelo ID");
		System.out.println("--- 7 - Ativar/Desativar Fornecedor");
		System.out.println("");
		
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
			acaoSelecionada = listarTodosAtivos;
			break;
		case 6:
			acaoSelecionada = deletar;
			break;
		case 7:
			acaoSelecionada = ativarDesativar;
			break;
		default:
			acaoSelecionada = null;
			break;
		}
		
		if(acaoSelecionada != null) acaoSelecionada.executar();
		
	}

}
