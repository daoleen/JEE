package com.daoleen.jee.jpa;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 10/23/13
 * Time: 6:23 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllBooks", query = "SELECT b FROM Book b"),
        @NamedQuery(name = "findBookJava", query = "SELECT b FROM Book b WHERE b.title = 'Java'")
})
@Table(name = "Book")
public class Book {

    @javax.persistence.Id @GeneratedValue
    private Long Id;

    @NotNull
    private String title;

    @Size(min = 10, max = 2000)
    private String description;

    private Float price;
    private String isbn;
    private Integer nbOfPage;
    private boolean illustrations;

    // Constructors

    public Book() { }

    public Book(String title, String description, Float price, String isbn, Integer nbOfPage, boolean illustrations) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.isbn = isbn;
        this.nbOfPage = nbOfPage;
        this.illustrations = illustrations;
    }


    // Getters/Setters
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNbOfPage() {
        return nbOfPage;
    }

    public void setNbOfPage(Integer nbOfPage) {
        this.nbOfPage = nbOfPage;
    }

    public boolean isIllustrations() {
        return illustrations;
    }

    public void setIllustrations(boolean illustrations) {
        this.illustrations = illustrations;
    }
}
