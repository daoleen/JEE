package com.daoleen.jee.jpa_authorization;

import javax.ejb.Remote;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 11/3/13
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */

@Remote
public interface BookEJBRemote {
    List<Book> findBooks();
    @NotNull Book createBook(@NotNull Book book);
    @NotNull Book updateBook(@NotNull Book book);
    void deleteBook(@NotNull Book book);
}
