package com.agenda.agendapia.entities;

import javax.persistence.*;

@Entity
@Table(name="providers")
public class Provider extends MarketPerson {
    @Column(name = "isActive", nullable = true)
    private boolean isActive;
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    public boolean getIsActive() {
        return this.isActive;
    }
    public Provider(String name, String firstLastName, String secondLastName, String email, String phoneNumber, boolean isActive) {
        super(name, firstLastName, secondLastName, email, phoneNumber);
        this.isActive = isActive;
    }
    public Provider() {
    }
}
