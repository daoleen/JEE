package com.daoleen.jee.jpa_authorization;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 11/3/13
 * Time: 5:09 PM
 * To change this template use File | Settings | File Templates.
 */

public class DatabaseProducer {
    @Produces
    @PersistenceContext(unitName = "DbJpaAuthorization")
    private EntityManager em;
}
