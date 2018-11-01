package com.eprogrammerz.examples.rest.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class Employee {

    @NotEmpty
    @Size(min = 4, max = 50, message = "Size must be between {2} and {1}")
    private String firstName;

    @NotEmpty
    @Size(min = 4, max = 50, message = "Size must be between {2} and {1}")
    private String lastName;

    @NotEmpty
    @Email
    private String email;

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

}
