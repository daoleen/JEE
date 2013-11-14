package com.daoleen.jee.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 10/23/13
 * Time: 7:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String args[]) {
        Book book = new Book("Java", "A book about java", 12.28f, "13-234394", 1293, true);

        // Obtains an entity manager and a transaction
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JpaIntroductionDb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Save the book to database
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(book);
        transaction.commit();

        // Closing connections
        entityManager.close();
        entityManagerFactory.close();
    }
}
