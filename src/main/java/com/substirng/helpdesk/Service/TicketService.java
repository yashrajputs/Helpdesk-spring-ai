package com.substirng.helpdesk.Service;

import org.springframework.stereotype.Service;
import com.substirng.helpdesk.repository.TicketRepository;
import com.substirng.helpdesk.entity.Ticket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;




@Service
@Getter
@Setter
@AllArgsConstructor
public class TicketService {


    private final TicketRepository ticketRepository;


//create ticket
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    //update ticket
    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }


//get ticket by id
    public Ticket getTicketById(Long ticketId) {
        return ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + ticketId));
    }


    //get ticket by username
    public Ticket getTicketByUsername(String username) {
        return ticketRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Ticket not found with username: " + username));
    }





}
