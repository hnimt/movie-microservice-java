package fpt.trainining.movietheatre.repository;

import fpt.trainining.movietheatre.entity.ShowDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShowDateRepository extends JpaRepository<ShowDate, Integer> {
    List<ShowDate> getShowDateByShowDate(LocalDate showDate);
    Optional<ShowDate> findShowDateByShowDate(LocalDate showDate);
}
