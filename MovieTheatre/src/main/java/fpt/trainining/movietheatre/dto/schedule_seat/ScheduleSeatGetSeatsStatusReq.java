package fpt.trainining.movietheatre.dto.schedule_seat;

import lombok.Data;

@Data
public class ScheduleSeatGetSeatsStatusReq {
    private String movieId;
    private Integer showDateId;
    private Integer scheduleId;
}
