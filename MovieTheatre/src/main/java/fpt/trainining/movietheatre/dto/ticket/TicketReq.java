package fpt.trainining.movietheatre.dto.ticket;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TicketReq {
    private Integer price;
    private Integer ticketType;
}
