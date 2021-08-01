package application;

import domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {

    public static void main(String[] args) {

        Person p1 = new Person(null, "Miriam Nunes", "mi@gmail.com"); // id nulo pq é autoincremental no bd
        Person p2 = new Person(null, "Daniel Nunes", "dani@gmail.com");
        Person p3 = new Person(null, "Cristiane Nunes", "cris@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        // esse cara instancia entity managers, que por sua vez, fazem a conexão com o banco de dados.

        EntityManager em = emf.createEntityManager();
        // com esse comando, estabelecemos uma conexão com o banco de dados e implementamos o contexto de persistência.

        em.getTransaction().begin(); // inicia uma transação com o banco de dados

        em.persist(p1); // persist salva o objeto no banco de dados.
        em.persist(p2);
        em.persist(p3);

        // find an object by ID:
        Person p = em.find(Person.class, 2);
        // nessa única linha, pesquisamos um objeto no bd, instanciamos, convertemos e atribuímos a um objeto Person!
        // jpa é vidaaaa

        System.out.println(p);

        // se quiser remover esse objeto 'p' q eu recuperei do banco de dados, fazer assim:
        em.remove(p);
        System.out.println("Removido!");

        em.getTransaction().commit(); // confirma a transação.

        System.out.println("Done!");
        em.close();
        emf.close();

        // buscar um objeto pelo ID:
    }
}
