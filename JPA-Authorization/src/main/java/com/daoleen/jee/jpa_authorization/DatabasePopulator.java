package com.daoleen.jee.jpa_authorization;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 11/3/13
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 */

@Singleton
@Startup
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name = "java:global/jdbc/DbJpaAuthorizationDataSource",
        user = "app",
        password = "app",
        databaseName = "DbJpaAuthorization",
        properties = { "connectionAttributes;create=true" }
)
public class DatabasePopulator {
    @Inject
    private BookEJB bookEJB;

    private Book java7;
    private Book pascal;


    @PostConstruct
    private void populateDb() {
        java7 = new Book("Java7", 7.27f, "Book about Java", "13-12-17214", 2180, true);
        pascal = new Book("Pascal", 1.12f, "Book about Pascal", "312-3213-123", 360, false);

        bookEJB.createBook(java7);
        bookEJB.createBook(pascal);
    }

    @PreDestroy
    private void clearDb() {
        bookEJB.deleteBook(java7);
        bookEJB.deleteBook(pascal);
    }

}
