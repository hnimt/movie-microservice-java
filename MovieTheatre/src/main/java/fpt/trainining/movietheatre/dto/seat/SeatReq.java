package fpt.trainining.movietheatre.dto.seat;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SeatReq {
    @NotNull
    private Integer cinemaRoomId;

    private String seatColumn;

    private Integer seatRow;

    private Integer seatStatus;

    private Integer seatType;
}
