package fpt.trainining.movietheatre.dto.seat;

import fpt.trainining.movietheatre.entity.CinemaRoom;
import lombok.Data;

@Data
public class SeatRes {
    private Integer seatId;

    private CinemaRoom cinemaRoom;

    private String seatColumn;

    private Integer seatRow;

    private Integer seatStatus;

    private Integer seatType;
}
