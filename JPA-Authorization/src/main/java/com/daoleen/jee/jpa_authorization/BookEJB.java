package com.daoleen.jee.jpa_authorization;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 11/3/13
 * Time: 3:39 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
@LocalBean
public class BookEJB implements BookEJBRemote {
    @PersistenceContext(unitName = "DbJpaAuthorization")
    private EntityManager em;


    public List<Book> findBooks() {
        return em.createNamedQuery(Book.FIND_ALL, Book.class)
                .getResultList();
    }


    public @NotNull Book createBook(@NotNull Book book) {
        em.persist(book);
        return book;
    }


    public @NotNull Book updateBook(@NotNull Book book) {
        return em.merge(book);
    }


    public void deleteBook(@NotNull Book book) {
        em.merge(book);
        em.remove(book);
    }
}
