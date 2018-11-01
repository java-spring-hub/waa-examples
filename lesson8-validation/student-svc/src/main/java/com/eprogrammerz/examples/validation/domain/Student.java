package com.eprogrammerz.examples.validation.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


public class Student implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int id;

    @NotEmpty
    @Size(min = 4, max = 50, message = "{Size.name.validation}")
    private String firstName = null;

    @NotEmpty
    @Size(min = 4, max = 50, message = "{Size.name.validation}")
    private String lastName = null;

    @NotEmpty
    @Email(message = "Invalid email address.")
    private String email = null;

    private String gender = null;

    @NotNull
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthday;

    @Valid
    private Phone phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }


}
