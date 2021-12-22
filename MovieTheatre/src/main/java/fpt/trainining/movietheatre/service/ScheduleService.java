package fpt.trainining.movietheatre.service;

import fpt.trainining.movietheatre.dto.schedule.ScheduleRequest;
import fpt.trainining.movietheatre.dto.schedule.ScheduleResponse;
import fpt.trainining.movietheatre.entity.Schedule;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ScheduleService {
    ResponseEntity<List<ScheduleResponse>> getAll();
    ResponseEntity<ScheduleResponse> create(ScheduleRequest request);

    Schedule findById(Integer scheduleId);
}
