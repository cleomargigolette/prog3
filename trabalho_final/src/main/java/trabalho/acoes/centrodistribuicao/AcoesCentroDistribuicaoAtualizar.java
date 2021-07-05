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
public class AcoesCentroDistribuicaoAtualizar implements Acoes{

	@Override
	public void executar() {
		
		Teclado teclado = new Teclado();
		CentroDistribuicaoDAO centroDistribuicaoDAO = new CentroDistribuicaoDAO();

		System.out.println();
		System.out.println("--- Informe o id do Centro de Distribuicao que deseja atualizar:");
		int id = teclado.leInt();

		CentroDistribuicao centroDistribuicao = centroDistribuicaoDAO.obter(id);

		if (centroDistribuicao == null) {

			System.out.println("--- O Centro de Distribuicao com este id não foi encontrado.");

		} else {

			System.out.println("--- Informe a UF do centroDistribuicao:");
			centroDistribuicao.setUf(teclado.leString());

			System.out.println("--- Informe a Cidade do centroDistribuicao:");
			centroDistribuicao.setCidade(teclado.leString());

			System.out.println("--- Informe o Bairro do centroDistribuicao:");
			centroDistribuicao.setBairro(teclado.leString());

			System.out.println("--- Informe a Rua do centroDistribuicao:");
			centroDistribuicao.setRua(teclado.leString());

			System.out.println("--- Informe o Número do centroDistribuicao:");
			centroDistribuicao.setNumero(teclado.leInt());

			System.out.println("--- Informe o Complemento do centroDistribuicao:");
			centroDistribuicao.setComplemento(teclado.leString());;

			boolean atualizou = centroDistribuicaoDAO.atualiza(centroDistribuicao);
			
			String print = atualizou ? "--- Centro de Distribuicao foi atualizado com sucesso!" : "--- O Centro de Distribuicao não foi atualizado!";

			System.out.println(print);

		}
		
	}

}
