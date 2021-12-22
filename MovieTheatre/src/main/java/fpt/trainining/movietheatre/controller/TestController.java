package fpt.trainining.movietheatre.controller;

import fpt.trainining.movietheatre.dto.test.TestReq;
import fpt.trainining.movietheatre.entity.ScheduleSeat;
import fpt.trainining.movietheatre.service.ScheduleSeatService;
import fpt.trainining.movietheatre.service.SeatService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {
    private final ScheduleSeatService service;
    private final SeatService seatService;

    @GetMapping
    public String testAuthority() {
        return "Success";
    }

    @GetMapping("/sth")
    public ResponseEntity<Boolean> testSth(@RequestBody @Valid TestReq req) {
        return ResponseEntity.ok(service.changeSeatStatus(req.getMovieId(), req.getShowDateId(), req.getScheduleId(), req.getSeatIdString()));
    }

    @GetMapping("/sth2/{seatNames}")
    public ResponseEntity<List<Integer>> testSth2(@PathVariable String seatNames) {
        System.out.println(seatNames);
        return ResponseEntity.ok(seatService.findIdBySeatName(seatNames));
    }

    @PostMapping("/sth3")
    public ResponseEntity<List<ScheduleSeat>> testSth3(@RequestBody @Valid TestReq req) {
        return ResponseEntity.ok(service.getScheduleSeatChangedStatus(req.getMovieId(), req.getShowDateId(), req.getScheduleId(), req.getSeatIdString()));
    }
}
