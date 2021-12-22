package fpt.trainining.movietheatre.service.mapper;

import fpt.trainining.movietheatre.dto.seat.SeatIdReq;
import fpt.trainining.movietheatre.dto.seat.SeatReq;
import fpt.trainining.movietheatre.dto.seat.SeatRes;
import fpt.trainining.movietheatre.entity.CinemaRoom;
import fpt.trainining.movietheatre.entity.Seat;
import fpt.trainining.movietheatre.exception.ResourceNotFoundException;
import fpt.trainining.movietheatre.repository.CinemaRoomRepository;
import fpt.trainining.movietheatre.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class SeatMapper {
    private final ModelMapper mapper;
    private final SeatRepository repository;
    private final CinemaRoomRepository cinemaRoomRepository;

    public Seat map(SeatReq req) {
        Seat seat = mapper.map(req, Seat.class);

        Optional<CinemaRoom> optionalCinemaRoom = cinemaRoomRepository.findById(req.getCinemaRoomId());

        if (!optionalCinemaRoom.isPresent()) {
            throw new ResourceNotFoundException("Can not find any cinema room with id: " + req.getCinemaRoomId());
        }

        //neu ton tai cinema room, tang so luong ghe cua room do
        CinemaRoom cinemaRoom = optionalCinemaRoom.get();
        cinemaRoom.setSeatQuantity(cinemaRoom.getSeatQuantity() + 1);
        cinemaRoomRepository.save(cinemaRoom);

        seat.setCinemaRoom(cinemaRoom);

        return seat;
    }

    public Seat map(SeatIdReq req) {
        Optional<Seat> optionalSeat = repository.findById(req.getSeatId());

        if (!optionalSeat.isPresent()) {
            throw new ResourceNotFoundException("Can not find seat with id = " + req.getSeatId());
        }

        return optionalSeat.get();
    }

    public SeatRes map(Seat seat) {
        return mapper.map(seat, SeatRes.class);
    }
}
