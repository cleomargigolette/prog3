/**
 * 
 */
package trabalho.acoes.centrodistribuicao;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.CentroDistribuicaoDAO;
import trabalho.dados.entidades.CentroDistribuicao;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesCentroDistribuicaoDeletar implements Acoes {

	@Override
	public void executar() {
		
		CentroDistribuicaoDAO centroDistribuicaoDAO = new CentroDistribuicaoDAO();
		Teclado teclado = new Teclado();
		
		System.out.println("--- Informe o ID do Centro de Distribuicao:");
		CentroDistribuicao centroDistribuicao = centroDistribuicaoDAO.obter(teclado.leInt());
	 	
	 	if(centroDistribuicao == null) {
	 		
	 		System.out.println("--- O Centro de Distribuicao com este id não foi encontrado.");
	 		
	 	}else {
	 		
	 		boolean deleted = centroDistribuicaoDAO.deleta(centroDistribuicao);
	 		
	 		String print = deleted ? "--- Centro de Distribuicao foi deletetado com sucesso!" : "--- O Centro de Distribuicao não foi deletetado!";
			System.out.println(print);
			
	 	}                             
		
	}

}
