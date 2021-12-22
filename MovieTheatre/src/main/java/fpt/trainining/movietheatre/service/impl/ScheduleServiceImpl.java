package fpt.trainining.movietheatre.service.impl;

import fpt.trainining.movietheatre.dto.schedule.ScheduleRequest;
import fpt.trainining.movietheatre.dto.schedule.ScheduleResponse;
import fpt.trainining.movietheatre.entity.Schedule;
import fpt.trainining.movietheatre.exception.ResourceNotFoundException;
import fpt.trainining.movietheatre.repository.ScheduleRepository;
import fpt.trainining.movietheatre.service.ScheduleService;
import fpt.trainining.movietheatre.service.mapper.ScheduleMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleMapper mapper;
    private final ScheduleRepository repository;

    @Override
    public ResponseEntity<List<ScheduleResponse>> getAll() {
        List<Schedule> schedules = repository.findAll();

        List<ScheduleResponse> responses = schedules.stream()
                .map(mapper::map)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<ScheduleResponse> create(ScheduleRequest request) {
        Schedule schedule = mapper.map(request);

        repository.save(schedule);

        return ResponseEntity.ok(mapper.map(schedule));
    }

    @Override
    public Schedule findById(Integer scheduleId) {
        return repository.findById(scheduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot found schedule"));
    }
}
