/**
 * 
 */
package trabalho.acoes.fornecedor;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.FornecedorDAO;
import trabalho.dados.entidades.Fornecedor;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesFornecedorInserir implements Acoes{

	@Override
	public void executar() {
		
		Teclado teclado = new Teclado();
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		Fornecedor fornecedor = new Fornecedor();
		
		System.out.println("--- Informe nome do Fornecedor:");
		fornecedor.setNome(teclado.leString());
		
		fornecedor.setAtivo(true);
		
		boolean inseriu = fornecedorDAO.insere(fornecedor);
		
		String print = inseriu ? "--- Fornecedor inserido com sucesso!" : "--- O novo Fornecedor não foi inserido!";
		
		System.out.println(print);
	}

}
