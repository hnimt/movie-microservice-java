package fpt.trainining.movietheatre.service.mapper;

import fpt.trainining.movietheatre.dto.schedule_seat.ScheduleSeatGetSeatsStatusReq;
import fpt.trainining.movietheatre.dto.schedule_seat.ScheduleSeatGetSeatsStatusRes;
import fpt.trainining.movietheatre.exception.ResourceNotFoundException;
import fpt.trainining.movietheatre.repository.ScheduleSeatRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class ScheduleSeatMapper {
    private final ModelMapper mapper;
    private final ScheduleSeatRepository repository;

    @Data
    private class SeatIdAndSeatStatus {
        private Integer seatId;
        private Integer seatStatus;
    }

    public ScheduleSeatGetSeatsStatusRes mapReqToRes(ScheduleSeatGetSeatsStatusReq req) {
        ScheduleSeatGetSeatsStatusRes res = mapper.map(req, ScheduleSeatGetSeatsStatusRes.class);

        List<Map<String, Integer>> list = new ArrayList<>();
        repository.findScheduleSeatByMovieIdAndShowDateIdAndScheduleId(
                        req.getMovieId(),
                        req.getShowDateId(),
                        req.getScheduleId()
                )
                .orElseThrow(() -> new ResourceNotFoundException("Can not find schedule seat"))
                .stream()
                .forEach(scheduleSeat -> {
                    Map<String, Integer> map = new HashMap<>();
                    map.put("seat id", scheduleSeat.getSeatId());
                    map.put("seat status", scheduleSeat.getSeatStatus());
                    list.add(map);
                });

        res.setStatusList(list);
        return res;
    }

}
