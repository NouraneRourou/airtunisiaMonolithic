package com.example.airtunisia.Service;

import com.example.airtunisia.Model.Ticket;
import com.example.airtunisia.Repository.TicketRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Service/TicketService")

public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @GetMapping(value = "/findAllTickets")
    public List findTicket(){
        List ticketList = ticketRepository.findAll();
        return ticketList;
    }

    @PostMapping(value= "/saveTicket")
    public Ticket newTicket(@RequestBody Ticket newTicket) {
      //  System.out.println(newTicket.getFlight().getId());
        ticketRepository.save(newTicket);
        return newTicket;
    }

    @DeleteMapping(value = "/deleteTicket/{id}")
    public String deleteTicket(@PathVariable int id) {
        ticketRepository.deleteById(id);
        return "OK!";
    }
    @PutMapping(value = "/editTicket/{id}")
    public Ticket editTicket(@RequestBody Ticket ticketInfo, @PathVariable int id) {
        Ticket ticket = ticketRepository.findById(id);
        ticket.setPrice(ticketInfo.getPrice());
        ticketRepository.save(ticket);
        return ticket;
    }
}
