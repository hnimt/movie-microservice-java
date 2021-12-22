package fpt.trainining.movietheatre.repository;

import fpt.trainining.movietheatre.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
    Optional<Movie> findMovieByMovieNameEnglish(String englishName);

    @Query("SELECT m FROM Movie m WHERE m.movieNameEnglish LIKE %?1%")
    Optional<List<Movie>> getMoviesEnglishNameContains(String string);
}
