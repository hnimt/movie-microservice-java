package fpt.trainining.movietheatre.service;

import fpt.trainining.movietheatre.dto.ticket.TicketReq;
import fpt.trainining.movietheatre.entity.Ticket;

public interface TicketService {
    Ticket getById(Integer id);
    Ticket create(TicketReq req);
    Ticket update(Integer id, TicketReq req);
    void deleteById(Integer id);
    Ticket findByPrice(Integer price);
    Ticket findByType(Integer type);
}
