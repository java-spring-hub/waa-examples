package com.eprogrammerz.examples.jpa.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Entity
public class Employee implements Serializable {
    private static final long serialVersionUID = -908L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMP_ID")
    private long id;

    @Column(name = "F_NAME")
    private String firstName;
    @Column(name = "L_NAME")
    private String lastName;
    private Integer salary;

    //  @ManyToMany(cascade = CascadeType.MERGE)
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)

    // FetchMode.JOIN will do eager load also
//    @Fetch(FetchMode.JOIN)  //  dups are probable with list so use set...
    private Set<Address> addresses;

    // change to lazy ..change to OneToManyUniJoinColumn also  to see LAZY exception
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // Defaults to table IF no Join Mentioned [ comment out Join column to see]
    @JoinColumn(name = "OWNER_ID")
    private List<Phone> phones;

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

}
