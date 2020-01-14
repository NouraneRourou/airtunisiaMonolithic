package com.example.airtunisia.Repository;

import com.example.airtunisia.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TicketRepository extends JpaRepository <Ticket, Integer> {

    Ticket findById(int id);

}
