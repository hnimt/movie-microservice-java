package fpt.trainining.movietheatre.service;

import fpt.trainining.movietheatre.dto.cinema_room.CinemaRoomReq;
import fpt.trainining.movietheatre.dto.cinema_room.CinemaRoomRes;
import fpt.trainining.movietheatre.entity.CinemaRoom;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CinemaRoomService {
    ResponseEntity<List<CinemaRoomRes>> getAll();
    ResponseEntity<CinemaRoomRes> getById(Integer id);
    ResponseEntity<CinemaRoomRes> create(CinemaRoomReq req);
    ResponseEntity<CinemaRoomRes> update(Integer id, CinemaRoomReq req);
    void deleteById(Integer id);
}
