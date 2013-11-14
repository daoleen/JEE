package com.daoleen.jee.jpa.test;

import com.daoleen.jee.jpa.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 10/23/13
 * Time: 7:16 PM
 * To change this template use File | Settings | File Templates.
 */

public class BookIT {

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction transaction;

    static {
        entityManagerFactory  = Persistence
                .createEntityManagerFactory("JpaIntroductionDbTest");
    }

    @Before
    public void initEntityManager() throws Exception {
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    @After
    public void closeEntityManager() throws Exception {
        if(entityManager != null) {
            entityManager.close();
        }
    }


    @Test
    public void shouldFindJavaBook() {
        Book book = entityManager.find(Book.class, 1L);
        assertEquals("Java", book.getTitle());
    }
/*
    @Test
    public void shouldCreateJavaBook() {
        Book book = new Book("Java", "A book about java", 12.28f, "13-234394", 1293, true);

        transaction.begin();
        entityManager.persist(book);
        transaction.commit();
        assertNotNull("Id should not be null", book.getId());

        // Retrieve the book from database
        book = entityManager.createNamedQuery("findBookJava", Book.class).getSingleResult();
        assertEquals("A book about java", book.getDescription());
    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldRaiseConstraintViolationCauseNullTitle() {
        Book book = new Book(null, "title", 12f, "123", 20, false);
        transaction.begin();
        entityManager.persist(book);
        transaction.commit();
    }*/
}
