package fpt.trainining.movietheatre.service.mapper;

import fpt.trainining.movietheatre.dto.cinema_room.CinemaRoomReq;
import fpt.trainining.movietheatre.dto.cinema_room.CinemaRoomRes;
import fpt.trainining.movietheatre.entity.CinemaRoom;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CinemaRoomMapper {
    private ModelMapper mapper;

    public CinemaRoom map(CinemaRoomReq req) {
        CinemaRoom cinemaRoom = mapper.map(req, CinemaRoom.class);

        cinemaRoom.setSeatQuantity(0);

        return cinemaRoom;
    }

    public CinemaRoomRes map(CinemaRoom cinemaRoom) {
        return mapper.map(cinemaRoom, CinemaRoomRes.class);
    }

    public void map(CinemaRoomReq req, CinemaRoom cinemaRoom) {
        mapper.map(req, cinemaRoom);
    }
}
