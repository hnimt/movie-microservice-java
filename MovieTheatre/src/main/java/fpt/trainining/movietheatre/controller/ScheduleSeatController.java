package fpt.trainining.movietheatre.controller;

import fpt.trainining.movietheatre.dto.schedule_seat.ScheduleSeatGetSeatsStatusReq;
import fpt.trainining.movietheatre.dto.schedule_seat.ScheduleSeatGetSeatsStatusRes;
import fpt.trainining.movietheatre.entity.ScheduleSeat;
import fpt.trainining.movietheatre.service.ScheduleSeatService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/schedule-seat")
@AllArgsConstructor
public class ScheduleSeatController {
    private final ScheduleSeatService service;

    @GetMapping("/get-seats-status")
    public ResponseEntity<ScheduleSeatGetSeatsStatusRes> getSeatsStatus(@RequestBody @Valid ScheduleSeatGetSeatsStatusReq req) {
        return ResponseEntity.ok(service.getSeatsStatus(req));
    }
}
