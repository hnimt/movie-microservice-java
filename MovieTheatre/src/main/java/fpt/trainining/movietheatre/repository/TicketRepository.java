package fpt.trainining.movietheatre.repository;

import fpt.trainining.movietheatre.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    Optional<Ticket> findTicketByPrice(Integer price);
    Optional<Ticket> findTicketByTicketType(Integer ticketType);
}
