package ienh.entidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Programa {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args){

        entityManagerFactory = Persistence.createEntityManagerFactory("Escola");
        entityManager = entityManagerFactory.createEntityManager();

        Aluno aluno1 = entityManager.find(Aluno.class, 4);

        List<Curso> cursoList = aluno1.getCursos();


        cursoList.forEach(curso -> {
            System.out.println(curso.getNome());
        });

        System.out.println(aluno1.getPrimeiroNome());
        System.out.println(aluno1.getUltimoNome());

        entityManager.close();
        entityManagerFactory.close();

    }

}
