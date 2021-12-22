package fpt.trainining.movietheatre.controller;

import fpt.trainining.movietheatre.dto.schedule.ScheduleRequest;
import fpt.trainining.movietheatre.dto.schedule.ScheduleResponse;
import fpt.trainining.movietheatre.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/schedule")
@AllArgsConstructor
public class ScheduleController {
    private final ScheduleService service;

    @GetMapping("/get")
    public ResponseEntity<List<ScheduleResponse>> getAll() {
        return service.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<ScheduleResponse> create(@RequestBody @Valid ScheduleRequest request) {
        return service.create(request);
    }
}
