package com.daoleen.jee.cdi;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 10/17/13
 * Time: 1:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoggingProducer {

    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}
