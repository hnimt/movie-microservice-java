package fpt.trainining.movietheatre.service.impl;

import fpt.trainining.movietheatre.exception.ResourceNotFoundException;
import fpt.trainining.movietheatre.service.mapper.CinemaRoomMapper;
import fpt.trainining.movietheatre.dto.cinema_room.CinemaRoomReq;
import fpt.trainining.movietheatre.dto.cinema_room.CinemaRoomRes;
import fpt.trainining.movietheatre.entity.CinemaRoom;
import fpt.trainining.movietheatre.repository.CinemaRoomRepository;
import fpt.trainining.movietheatre.service.CinemaRoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CinemaRoomServiceImpl implements CinemaRoomService {
    private final CinemaRoomMapper mapper;
    private final CinemaRoomRepository repository;

    private CinemaRoom findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot find cinema room with id = " + id));
    }

    @Override
    public ResponseEntity<List<CinemaRoomRes>> getAll() {
        List<CinemaRoom> cinemaRooms = repository.findAll();

        List<CinemaRoomRes> cinemaRoomRes = cinemaRooms.stream()
                .map(mapper::map)
                .collect(Collectors.toList());

        return ResponseEntity.ok(cinemaRoomRes);
    }

    @Override
    public ResponseEntity<CinemaRoomRes> getById(Integer id) {
        return ResponseEntity.ok(mapper.map(findById(id)));
    }

    @Override
    public ResponseEntity<CinemaRoomRes> create(CinemaRoomReq req) {
        CinemaRoom cinemaRoom = mapper.map(req);

        repository.save(cinemaRoom);

        return ResponseEntity.ok(mapper.map(cinemaRoom));
    }

    @Override
    public ResponseEntity<CinemaRoomRes> update(Integer id, CinemaRoomReq req) {
        CinemaRoom cinemaRoom = findById(id);
        mapper.map(req, cinemaRoom);
        return ResponseEntity.ok(mapper.map(cinemaRoom));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
