package trabalho.gui.menu;

import trabalho.uteis.Teclado;

public class ControladorMenu {

	private Menu menuFornecedor = new MenuFornecedor();
	private Menu menuCentroDistribuicao = new MenuCentroDistribuicao();
	private Menu menuContato = new MenuContato();
	private Menu menuProduto = new MenuProduto();
	private Menu menuPedido = new MenuPedido();

	Menu menuSelecionado = null;

	public void executar() {

		Teclado teclado = new Teclado();
		int opcaoPrimaria;
		int opcaoSecundaria;

		do {
			
			exibeMenuPrincipal();
			opcaoPrimaria = teclado.leInt();
			
			if (opcaoPrimaria != -1) {
				
				menuSelecionado = obterMenuSecundario(opcaoPrimaria);
				
				if (menuSelecionado != null) {
					
					menuSelecionado.exibe();
					
					opcaoSecundaria = teclado.leInt();
					
					menuSelecionado.executarOpcao(opcaoSecundaria);
				}
			}
			
		} while (opcaoPrimaria != -1);

	}

	private Menu obterMenuSecundario(int opcao) {

		switch (opcao) {
		case 1:
			return menuFornecedor;
		case 2:
			return menuCentroDistribuicao;
		case 3:
			return menuContato;
		case 4:
			return menuProduto;
		case 5:
			return menuPedido;
		default:
			return null;
		}
	}

	public void exibeMenuPrincipal() {
		
		System.out.println();
		System.out.println(" PRINCIPAL");
		System.out.println(" 1 - Fornecedores");
		System.out.println(" 2 - Centros de Distribuição de Fornecedor");
		System.out.println(" 3 - Contatos Fornecedor");
		System.out.println(" 4 - Produtos");
		System.out.println(" 5 - Pedidos");
		System.out.println();
		System.out.println(" Digite -1 para sair.");
		System.out.println();
	}

}
