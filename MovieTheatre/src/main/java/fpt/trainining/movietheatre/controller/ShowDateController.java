package fpt.trainining.movietheatre.controller;

import fpt.trainining.movietheatre.dto.show_date.ShowDateRequest;
import fpt.trainining.movietheatre.dto.show_date.ShowDateResponse;
import fpt.trainining.movietheatre.service.ShowDateService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/show-date")
@AllArgsConstructor
public class ShowDateController {
    private final ShowDateService service;

    @GetMapping("/get")
    public ResponseEntity<List<ShowDateResponse>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get-by-date/{date}")
    public ResponseEntity<ShowDateResponse> getByDate(
            @PathVariable("date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return service.getByDate(date);
    }

    @PostMapping("/create")
    public ResponseEntity<ShowDateResponse> create(@RequestBody @Valid ShowDateRequest request) {
        return service.create(request);
    }

}
