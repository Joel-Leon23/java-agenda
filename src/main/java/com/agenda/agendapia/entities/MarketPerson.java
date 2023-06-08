package com.agenda.agendapia.entities;

import javax.persistence.*;

@Entity
@Table(name = "agenda")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class MarketPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    protected String name;
    @Column(name = "firstLastName")
    protected String firstLastName;
    @Column(name = "secondLastName")
    protected String secondLastName;
    @Column(name = "email")
    protected String email;
    @Column(name = "phoneNumber")
    protected String phoneNumber;

    public Long getId() {
        return id;
    }

    public MarketPerson() {
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }
    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }
    public String getFirstLastName() {
        return firstLastName;
    }
    public String getSecondLastName() {
        return secondLastName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public MarketPerson(String name, String firstLastName, String secondLastName, String email, String phoneNumber) {
        this.name = name;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
