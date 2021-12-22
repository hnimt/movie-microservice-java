package fpt.trainining.movietheatre.dto.ticket;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TicketRes {
    private Integer price;
    private Integer ticketType;
}
