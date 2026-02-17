package com.substirng.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.substirng.helpdesk.entity.Ticket;
import java.util.Optional;

public interface TicketRepository extends 
JpaRepository<Ticket, Long> {

    //Optional<Ticket> findByTicketId(Long id);
    Optional<Ticket> findByEmail(String email);

}
