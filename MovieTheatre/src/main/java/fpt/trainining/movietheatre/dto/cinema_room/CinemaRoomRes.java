package fpt.trainining.movietheatre.dto.cinema_room;

import lombok.Data;

@Data
public class CinemaRoomRes {
    private Integer roomId;
    private String cinemaRoomName;
    private Integer seatQuantity;
}
