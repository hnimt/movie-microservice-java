package fpt.trainining.movietheatre.controller;

import fpt.trainining.movietheatre.dto.ResponseHandler;
import fpt.trainining.movietheatre.dto.cinema_room.CinemaRoomReq;
import fpt.trainining.movietheatre.dto.cinema_room.CinemaRoomRes;
import fpt.trainining.movietheatre.service.CinemaRoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cinema-room")
@AllArgsConstructor
public class CinemaRoomController {
    private final CinemaRoomService service;

    @GetMapping("/get")
    public ResponseEntity<List<CinemaRoomRes>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<CinemaRoomRes> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<CinemaRoomRes> create(@RequestBody @Valid CinemaRoomReq req) {
        return service.create(req);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CinemaRoomRes> update(@PathVariable Integer id, @RequestBody @Valid CinemaRoomReq req) {
        return service.update(id, req);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity remove(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseHandler.generateResponse("Delete cinema successfully", HttpStatus.OK, null);
    }
}
