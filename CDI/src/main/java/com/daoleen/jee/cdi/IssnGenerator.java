package com.daoleen.jee.cdi;

import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 10/17/13
 * Time: 12:44 AM
 * To change this template use File | Settings | File Templates.
 */

@EigthDigits
public class IssnGenerator implements NumberGenerator {

    @Inject
    private Logger logger;

    @Loggable
    public String generateNumber() {
        String issn = "8-" + Math.abs(new Random().nextInt());
        logger.info("Generated ISSN: " + issn);
        return issn;
    }
}
