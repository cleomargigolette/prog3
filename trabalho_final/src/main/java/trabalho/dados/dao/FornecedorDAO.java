/**
 * 
 */
package trabalho.dados.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import trabalho.conexao.ConexaoHibernate;
import trabalho.dados.entidades.Fornecedor;

/**
 * @author cleomar
 *
 */
public class FornecedorDAO implements DAO<Fornecedor> {

	public static EntityManager entityManager;

	public FornecedorDAO() {
		entityManager = ConexaoHibernate.getEntityManager();
	}

	@Override
	public Fornecedor obter(int id) {

		Fornecedor fornecedor = entityManager.find(Fornecedor.class, id);

		return fornecedor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fornecedor> obterTodos() {

		List<Fornecedor> fornecedores = null;

		try {

			fornecedores = entityManager.createQuery("from Fornecedor").getResultList();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return fornecedores;
	}

	@Override
	public boolean insere(Fornecedor t) {

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
	public boolean atualiza(Fornecedor t) {

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
	public boolean deleta(Fornecedor t) {

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

	@SuppressWarnings("unchecked")
	public List<Fornecedor> obterTodosAtivos() {
		
		List<Fornecedor> fornecedores = new ArrayList<>();

		try {

			fornecedores = entityManager.createQuery("from Fornecedor where ativo = 1").getResultList();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return fornecedores;
	}

}
