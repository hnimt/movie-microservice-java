package fpt.trainining.movietheatre.repository;

import fpt.trainining.movietheatre.entity.ScheduleSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleSeatRepository extends JpaRepository<ScheduleSeat, String> {
    Optional<List<ScheduleSeat>> findScheduleSeatByMovieIdAndShowDateIdAndScheduleId(String movieId, Integer showDateId, Integer scheduleId);

    Optional<ScheduleSeat> findScheduleSeatByMovieIdAndShowDateIdAndScheduleIdAndSeatId(String movieId, Integer showDateId, Integer scheduleId, Integer seatId);
}
