package com.daoleen.jee.jpa_authorization.test;

import com.daoleen.jee.jpa_authorization.Book;
import com.daoleen.jee.jpa_authorization.BookEJB;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 11/3/13
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */

public class BookEJBIT {
    @Test
    public void shouldCreateABook() throws Exception {
        Map<String, Object> properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));

        try(EJBContainer ec = EJBContainer.createEJBContainer(properties)) {
            Context ctx = ec.getContext();

            // Check JNDI dependencies (Datasource and EJBs)
            assertNotNull(ctx.lookup("java:global/jdbc/DbJpaAuthorizationDataSource"));
            assertNotNull(ctx.lookup("java:global/classes/BookEJB!com.daoleen.jee.jpa_authorization.BookEJBRemote"));
            assertNotNull(ctx.lookup("java:global/classes/BookEJB!com.daoleen.jee.jpa_authorization.BookEJB"));

            // Look up the EJB
            BookEJB bookEJB = (BookEJB) ctx.lookup("java:global/classes/BookEJB!com.daoleen.jee.jpa_authorization.BookEJB");

            // Find all the books and makes sure there are two (inserted by the DbPopulator)
            assertEquals(2, bookEJB.findBooks().size());

            // Creates an instance of Book
            Book book = new Book("Scala", 1.11f, "Book about scala", "123-12-1111", 110, false);

            // Persists the Book to the database
            book = bookEJB.createBook(book);
            assertNotNull("Id should not be null", book.getId());

            // All books size
            assertEquals(3, bookEJB.findBooks().size());

            // Removes the created Book
            bookEJB.deleteBook(book);

            // All books size
            assertEquals(2, bookEJB.findBooks().size());
        }
    }
}
