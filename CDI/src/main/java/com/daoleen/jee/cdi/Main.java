package com.daoleen.jee.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 10/17/13
 * Time: 1:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        BookService bookService = container.instance().select(BookService.class).get();

        Book book = bookService.createBook("JAVA EE 7", 12.5f, "Nice book but his author hard told )");

        System.out.println(book);

        weld.shutdown();
    }
}
