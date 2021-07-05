/**
 * 
 */
package trabalho.dados.dao;

import java.util.List;

import javax.persistence.EntityManager;

import trabalho.conexao.ConexaoHibernate;
import trabalho.dados.entidades.Pedido;

/**
 * @author cleomar
 *
 */
@SuppressWarnings("unchecked")
public class PedidoDAO implements DAO<Pedido>{
	
	public static EntityManager entityManager;

	public PedidoDAO() {
		entityManager = ConexaoHibernate.getEntityManager();
	}

	@Override
	public Pedido obter(int id) {
		
		Pedido pedido = entityManager.find(Pedido.class, id);

		return pedido;
	}

	@Override
	public List<Pedido> obterTodos() {
		
		List<Pedido> pedidos = null;

		try {

			pedidos = entityManager.createQuery("from Pedido").getResultList();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return pedidos;
	}

	@Override
	public boolean insere(Pedido t) {
		
		try {

			entityManager.getTransaction().begin();
			entityManager.persist(t);
			entityManager.getTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();

			return false;
		}

		return true;
	}

	@Override
	public boolean atualiza(Pedido t) {
		
		try {

			entityManager.getTransaction().begin();
			entityManager.merge(t);
			entityManager.getTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();

			return false;
		}

		return true;
	}

	@Override
	public boolean deleta(Pedido t) {
		
		try {

			entityManager.getTransaction().begin();
			entityManager.remove(t);
			entityManager.getTransaction().commit();

		} catch (Exception e) {

			e.printStackTrace();

			return false;
		}

		return true;
	}

	public double valorTotalDosPedidos() {
		
		List<Pedido> pedidos = null;

		try {

			pedidos = entityManager.createQuery("from Pedido").getResultList();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return pedidos.stream().mapToDouble(Pedido::getValorTotal).sum();
	}

}
