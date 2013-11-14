package com.daoleen.jee.cdi.test;

import com.daoleen.jee.cdi.Loggable;
import com.daoleen.jee.cdi.NumberGenerator;
import com.daoleen.jee.cdi.ThirteenDigits;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 10/17/13
 * Time: 12:48 AM
 * To change this template use File | Settings | File Templates.
 */

@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator {

    @Inject
    private Logger logger;

    @Loggable
    public String generateNumber() {
        String mock = "MOCK - " + Math.abs(new Random().nextInt());
        logger.info("Generated MOCK: " + mock);
        return mock;
    }
}
