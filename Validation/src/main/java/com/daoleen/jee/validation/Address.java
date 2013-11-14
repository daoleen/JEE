package com.daoleen.jee.validation;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 10/21/13
 * Time: 10:59 PM
 * To change this template use File | Settings | File Templates.
 */

public class Address {

    @NotNull
    private String street1;

    @NotNull
    private String city;

    @NotNull
    @ZipCode
    private String zipCode;

    private String street2;
    private String state;
    private String country;


    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
