package com.daoleen.jee.cdi;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 10/17/13
 * Time: 12:35 AM
 * To change this template use File | Settings | File Templates.
 */
@Loggable
public class BookService {

    @Inject @ThirteenDigits
    private NumberGenerator numberGenerator;

    public Book createBook(String title, Float price, String description) {
        Book book = new Book(title, price, description);
        String number = numberGenerator.generateNumber();
        book.setNumber(number);
        return book;
    }
}
