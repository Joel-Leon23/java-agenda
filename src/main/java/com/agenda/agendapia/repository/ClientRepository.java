package com.agenda.agendapia.repository;

import com.agenda.agendapia.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
