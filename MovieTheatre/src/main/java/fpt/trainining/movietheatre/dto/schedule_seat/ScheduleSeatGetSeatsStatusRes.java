package fpt.trainining.movietheatre.dto.schedule_seat;

import lombok.Data;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

@Data
public class ScheduleSeatGetSeatsStatusRes {
    private String movieId;
    private Integer showDateId;
    private Integer scheduleId;

    private List<Map<String, Integer>> statusList;
}
