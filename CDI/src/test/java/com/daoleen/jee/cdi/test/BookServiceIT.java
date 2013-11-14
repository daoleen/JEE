package com.daoleen.jee.cdi.test;

import com.daoleen.jee.cdi.Book;
import com.daoleen.jee.cdi.BookService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 10/19/13
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */

public class BookServiceIT {

    @Test
    public void shouldCheckNumberIsMOCK() {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        BookService bookService = container.instance().select(BookService.class).get();
        Book book = bookService.createBook("Test Mock", 7.65f, "Book for testing a mock");

        Assert.assertTrue(book.getNumber().startsWith("MOCK"));

        weld.shutdown();
    }
}
