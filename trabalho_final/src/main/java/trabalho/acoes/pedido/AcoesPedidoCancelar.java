/**
 * 
 */
package trabalho.acoes.pedido;

import trabalho.acoes.Acoes;
import trabalho.dados.dao.PedidoDAO;
import trabalho.dados.entidades.Pedido;
import trabalho.uteis.Teclado;

/**
 * @author cleomar
 *
 */
public class AcoesPedidoCancelar implements Acoes {

	@Override
	public void executar() {
		Teclado teclado = new Teclado();
		PedidoDAO pedidoDAO = new PedidoDAO();

		System.out.println();

		System.out.println("--- Informe o id do pedido que deseja atualizar:");
		int id = teclado.leInt();

		Pedido pedido = pedidoDAO.obter(id);

		if (pedido == null) {

			System.out.println("--- O pedido com este id não foi encontrado.");

		} else {
			
			pedido.setCancelado(true);
			
			String status = pedidoDAO.atualiza(pedido) ? "Pedido Cancelado com Sucesso!" : "Não foi possível cancelas o Pedido!" ;
			
			System.out.println(status);
		}

	}

}
