package fpt.trainining.movietheatre.service;

import fpt.trainining.movietheatre.dto.schedule_seat.ScheduleSeatGetSeatsStatusReq;
import fpt.trainining.movietheatre.dto.schedule_seat.ScheduleSeatGetSeatsStatusRes;
import fpt.trainining.movietheatre.entity.ScheduleSeat;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ScheduleSeatService {
    List<ScheduleSeat> getByMovieShowDateSchedule(String movieId, Integer showDateId, Integer scheduleId);
    ScheduleSeatGetSeatsStatusRes getSeatsStatus(ScheduleSeatGetSeatsStatusReq req);

    Boolean changeSeatStatus(String movieId, Integer showDateId, Integer scheduleId, String seatId);

    List<ScheduleSeat> getScheduleSeatChangedStatus(String movieId, Integer showDateId, Integer scheduleId, String seatId);
}
