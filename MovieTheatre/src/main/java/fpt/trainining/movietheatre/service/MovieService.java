package fpt.trainining.movietheatre.service;

import fpt.trainining.movietheatre.dto.movie.MovieRequest;
import fpt.trainining.movietheatre.dto.movie.MovieResponse;
import fpt.trainining.movietheatre.entity.Movie;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MovieService {
    Movie findById(String id);
    ResponseEntity<List<MovieResponse>> getAll();
    ResponseEntity<MovieResponse> getById(String id);
    ResponseEntity<MovieResponse> getByEnglishName(String name);
    ResponseEntity<List<MovieResponse>> getMoviesEnglishNameContains(String string);
    ResponseEntity<MovieResponse> create(MovieRequest request);
    ResponseEntity<MovieResponse> update(String id, MovieRequest request);
    void remove(String movieId);
}
