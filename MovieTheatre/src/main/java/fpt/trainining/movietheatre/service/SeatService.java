package fpt.trainining.movietheatre.service;

import fpt.trainining.movietheatre.dto.seat.SeatIdReq;
import fpt.trainining.movietheatre.dto.seat.SeatReq;
import fpt.trainining.movietheatre.dto.seat.SeatRes;
import fpt.trainining.movietheatre.entity.Seat;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SeatService {
    Seat findById(Integer id);
    List<Integer> findIdBySeatName(String seatNames);
    ResponseEntity<List<SeatRes>> getAll();
    ResponseEntity<SeatRes> create(SeatReq req);
    ResponseEntity<SeatRes> changeType(SeatIdReq req);
    ResponseEntity<SeatRes> changeStatus(SeatIdReq req);

    Seat changeStatus(Integer id);
    ResponseEntity delete(Integer seatId);
}
