package fpt.trainining.movietheatre.repository;

import fpt.trainining.movietheatre.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    Optional<Seat> findSeatBySeatRowAndSeatColumn(Integer seatRow, String seatColumn);
}
