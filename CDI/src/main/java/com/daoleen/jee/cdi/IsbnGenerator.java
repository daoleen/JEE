package com.daoleen.jee.cdi;

import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 10/17/13
 * Time: 12:41 AM
 * To change this template use File | Settings | File Templates.
 */
@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {

    @Inject
    private Logger logger;

    @Loggable
    public String generateNumber() {
        String isbn = "13-84356-" + Math.abs(new Random().nextInt());
        logger.info("Generated ISBN: " + isbn);
        return isbn;
    }
}
