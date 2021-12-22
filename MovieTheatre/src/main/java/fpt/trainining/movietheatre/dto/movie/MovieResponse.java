package fpt.trainining.movietheatre.dto.movie;

import fpt.trainining.movietheatre.entity.Schedule;
import fpt.trainining.movietheatre.entity.ShowDate;
import fpt.trainining.movietheatre.entity.Type;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Set;

@Data
public class MovieResponse {
    private String movieId;

    private String actor;

    private Integer cinemaRoomId;

    private String content;

    private String director;

    private Integer duration;

    private LocalDate fromDate;

    private String movieProductionCompany;

    private LocalDate toDate;

    private String version;

    private String movieNameEnglish;

    private String movieNameVn;

    private String largeImage;

    private String smallImage;

    private Collection<ShowDate> showDates;
    private Collection<Schedule> schedules;
    private Collection<Type> types;
}
