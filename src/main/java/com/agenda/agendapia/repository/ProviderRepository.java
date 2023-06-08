package com.agenda.agendapia.repository;

import com.agenda.agendapia.entities.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository <Provider, Long> {
}
