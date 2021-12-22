package fpt.trainining.movietheatre.dto.cinema_room;

import lombok.Data;

@Data
public class CinemaRoomReq {
    private String cinemaRoomName;
    private Integer seatQuantity;
}
