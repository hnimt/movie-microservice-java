package fpt.trainining.movietheatre.controller;

import fpt.trainining.movietheatre.dto.ResponseHandler;
import fpt.trainining.movietheatre.dto.ticket.TicketReq;
import fpt.trainining.movietheatre.entity.Ticket;
import fpt.trainining.movietheatre.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ticket")
@AllArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        Ticket ticket = ticketService.getById(id);
        return ResponseHandler.generateResponse("Get ticket successfully", HttpStatus.OK, ticket);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TicketReq req) {
        Ticket ticket = ticketService.create(req);
        return ResponseHandler.generateResponse("Create ticket successfully", HttpStatus.CREATED, ticket);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody TicketReq req) {
        Ticket ticket = ticketService.update(id, req);
        return ResponseHandler.generateResponse("Update ticket successfully", HttpStatus.OK, ticket);
    }
}
