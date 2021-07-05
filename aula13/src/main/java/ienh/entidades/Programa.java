package ienh.entidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Programa {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args){

        entityManagerFactory = Persistence.createEntityManagerFactory("BancoEscola");
        entityManager = entityManagerFactory.createEntityManager();

        /*
        Pessoafisica pessoafisica = entityManager.find(Pessoafisica.class, 4L);

        List<Conta> listContaPessofisica = pessoafisica.getContas();

        System.out.println(" Saldo das Contas do usuário: ");
        System.out.println(pessoafisica.getNome());
        listContaPessofisica.forEach(conta -> {

            System.out.println(conta.getSaldo());
        });
        */

        /*
        System.out.println("########################################################################");

        Agencia agencia = entityManager.find(Agencia.class, 1L);

        List<Conta> listContasAgencia = agencia.getContas();

        System.out.println(" Saldo das Contas do usuário: ");
        System.out.println(agencia.getNome());
        listContasAgencia.forEach(conta -> {

            System.out.println(conta.getSaldo());
        });
        */

        /*
        System.out.println("########################################################################");

        Gerente gerente = entityManager.find(Gerente.class, 1L);

        List<Conta> listContaGerente = gerente.getContas();

        System.out.println(" Saldo das Contas do gerente: ");
        System.out.println(gerente.getNome());
        listContaGerente.forEach(conta -> {

            System.out.println(conta.getSaldo());
        });
        */

        /*
        Query query = entityManager.createQuery("from Pessoafisica where telefone = '5135921276'");

        ArrayList<Pessoafisica> pessoafisicas = (ArrayList<Pessoafisica>) query.getResultList();

        for (Pessoafisica pessoafisica : pessoafisicas) {
            System.out.println(pessoafisica.getNome());
        }
        */

        /*
        Gerente gerente = entityManager.find(Gerente.class, 4L);

        gerente.getContas().forEach(conta -> {
            System.out.println(conta.getSaldo());
        });


        gerente.getContas().remove(0);

        entityManager.getTransaction().begin();
        entityManager.merge(gerente);
        entityManager.getTransaction().commit();
        */

        /*
        Conta conta = entityManager.find(Conta.class, 1L);
        conta.setLimite(1233.3);

        entityManager.getTransaction().begin();
        entityManager.merge(conta);
        entityManager.getTransaction().commit();
        */

        /*
        Gerente gerente= entityManager.find(Gerente.class, 2L);
        Pessoafisica pessoafisica = entityManager.find(Pessoafisica.class, 4L);
        Agencia agencia = entityManager.find(Agencia.class, 2L);

        Conta conta = new Conta();

        conta.setAgencia(agencia);
        conta.setPessoafisica(pessoafisica);
        conta.setGerente(gerente);
        conta.setLimite(1232);
        conta.setSaldo(500.0);
        conta.setNumero("77011");

        entityManager.getTransaction().begin();
        entityManager.persist(conta);
        entityManager.getTransaction().commit();
        */

        Query query = entityManager.createQuery("from Conta");


        List<Conta> contas = query.getResultList();

        System.out.println("Total de contas: "+contas.size());

        contas.forEach(conta -> {
            System.out.println("Saldo: "+conta.getSaldo());
            System.out.println("Límite: "+conta.getLimite());
            System.out.println("###################################################################################");
        });

        entityManager.close();
        entityManagerFactory.close();

    }

}
