package trabalho.dados.dao;

import java.util.List;

import javax.persistence.EntityManager;

import trabalho.conexao.ConexaoHibernate;
import trabalho.dados.entidades.CentroDistribuicao;

@SuppressWarnings("unchecked")
public class CentroDistribuicaoDAO implements DAO<CentroDistribuicao> {

	public static EntityManager entityManager;

	public CentroDistribuicaoDAO() {

		entityManager = ConexaoHibernate.getEntityManager();
	}

	public CentroDistribuicao obter(int id) {

		CentroDistribuicao centroDistribuicao = entityManager.find(CentroDistribuicao.class, id);

		return centroDistribuicao;
	}

	public List<CentroDistribuicao> obterTodos() {

		List<CentroDistribuicao> centrosDistribuicao = null;

		try {

			centrosDistribuicao = entityManager.createQuery("from CentroDistribuicao").getResultList();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return centrosDistribuicao;
	}

	public boolean insere(CentroDistribuicao t) {

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

	public boolean atualiza(CentroDistribuicao t) {

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

	public boolean deleta(CentroDistribuicao t) {

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

	public List<CentroDistribuicao> listarPorUF(String UF) {

		List<CentroDistribuicao> centrosDistribuicao = null;

		try {
			
			String query = "Select cd from CentroDistribuicao cd where cd.uf ='" +UF+"'";

			centrosDistribuicao = entityManager.createQuery(query).getResultList();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return centrosDistribuicao;
	}

}
