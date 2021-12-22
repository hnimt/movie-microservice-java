package fpt.trainining.movietheatre.repository;

import fpt.trainining.movietheatre.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    Optional<Schedule> findScheduleByScheduleTime(LocalTime scheduleTime);
}
