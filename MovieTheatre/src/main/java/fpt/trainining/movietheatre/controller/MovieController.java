package fpt.trainining.movietheatre.controller;

import fpt.trainining.movietheatre.dto.ResponseHandler;
import fpt.trainining.movietheatre.dto.movie.MovieRequest;
import fpt.trainining.movietheatre.dto.movie.MovieResponse;
import fpt.trainining.movietheatre.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@AllArgsConstructor
public class MovieController {
    private final MovieService service;

    @GetMapping("/get")
    public ResponseEntity<List<MovieResponse>> getAll() {
        return service.getAll();
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<MovieResponse> getById(@PathVariable(value = "id") String id) {
        return service.getById(id);
    }

    @GetMapping("/get-by-english-name/{name}")
    public ResponseEntity<MovieResponse> getByEnglishName(@PathVariable String name) {
        return service.getByEnglishName(name);
    }

    @GetMapping("/get-movies-english-name-contains/{string}")
    public ResponseEntity<List<MovieResponse>> getMoviesEnglishNameContains(@PathVariable String string) {
        return service.getMoviesEnglishNameContains(string);
    }

    @PostMapping("/create")
    public ResponseEntity<MovieResponse> create(@RequestBody @Valid MovieRequest request) {
        return service.create(request);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MovieResponse> update(@PathVariable(value = "id") String id, @RequestBody @Valid MovieRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") String id) {
        service.remove(id);
        return ResponseHandler.generateResponse("Delete movie successfully", HttpStatus.OK, null);
    }
}
