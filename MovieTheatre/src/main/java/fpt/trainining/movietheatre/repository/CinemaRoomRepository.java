package fpt.trainining.movietheatre.repository;

import fpt.trainining.movietheatre.entity.CinemaRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRoomRepository extends JpaRepository<CinemaRoom, Integer> {
}
