package fpt.trainining.movietheatre.service.mapper;

import fpt.trainining.movietheatre.dto.schedule.ScheduleRequest;
import fpt.trainining.movietheatre.dto.schedule.ScheduleResponse;
import fpt.trainining.movietheatre.entity.Schedule;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ScheduleMapper {
    private final ModelMapper mapper;

    public Schedule map(ScheduleRequest request) {
        return mapper.map(request, Schedule.class);
    }

    public ScheduleResponse map(Schedule schedule) {
        return mapper.map(schedule, ScheduleResponse.class);
    }
}
