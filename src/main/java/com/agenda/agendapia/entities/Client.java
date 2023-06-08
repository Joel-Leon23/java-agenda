package com.agenda.agendapia.entities;

import javax.persistence.*;

@Entity
@Table(name="clients")
public class Client extends MarketPerson {
    @Column(name = "hasMembership", nullable = true)
    boolean hasMembership;
    public void setHasMembership(boolean hasMembership) {
        this.hasMembership = hasMembership;
    }
    public boolean getHasMembership() {
        return this.hasMembership;
    }
    public Client() {
    }
    public Client(String name, String firstLastName, String secondLastName, String email, String phoneNumber, boolean hasMembership) {
        super(name, firstLastName, secondLastName, email, phoneNumber);
        this.hasMembership = hasMembership;
    }
}
