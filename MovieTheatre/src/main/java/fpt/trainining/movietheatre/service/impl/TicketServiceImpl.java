package fpt.trainining.movietheatre.service.impl;

import fpt.trainining.movietheatre.dto.ticket.TicketReq;
import fpt.trainining.movietheatre.entity.Ticket;
import fpt.trainining.movietheatre.exception.ResourceNotFoundException;
import fpt.trainining.movietheatre.repository.TicketRepository;
import fpt.trainining.movietheatre.service.TicketService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final ModelMapper mapper;

    public Ticket findById(Integer id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot find ticket id"));
    }

    @Override
    public Ticket getById(Integer id) {
        return findById(id);
    }

    @Override
    public Ticket create(TicketReq req) {
        Ticket ticket = mapper.map(req, Ticket.class);
        ticket = ticketRepository.save(ticket);
        return ticket;
    }

    @Override
    public Ticket update(Integer id, TicketReq req) {
        Ticket ticket = findById(id);
        mapper.map(req, ticket);
        ticket = ticketRepository.save(ticket);
        return ticket;
    }

    @Override
    public void deleteById(Integer id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public Ticket findByPrice(Integer price) {
        return ticketRepository.findTicketByPrice(price)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot found ticket"));
    }

    @Override
    public Ticket findByType(Integer type) {
        return ticketRepository.findTicketByTicketType(type)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot found ticket"));
    }
}
