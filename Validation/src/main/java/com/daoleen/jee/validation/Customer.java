package com.daoleen.jee.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: daoleen
 * Date: 10/21/13
 * Time: 10:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Customer {

    @NotNull
    @Size(min = 2)
    private String firstName;

    @Size(min = 3)
    private String lastName;

    @Email
    private String email;

    @Past
    private Date dateOfBirth;

    private Address deliveryAddress;
    private String phoneNumber;



    // Getters and Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
