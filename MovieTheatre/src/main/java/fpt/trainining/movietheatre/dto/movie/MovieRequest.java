package fpt.trainining.movietheatre.dto.movie;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Data
public class MovieRequest {
    private String actor;

    @NotNull
    private Integer cinemaRoomId;

    private String content;

    private String director;

    @NotNull
    private Integer duration;

    @NotNull
    private LocalDate fromDate;

    private String movieProductionCompany;

    @NotNull
    private LocalDate toDate;

    private String version;

    @NotNull
    private String movieNameEnglish;

    private String movieNameVn;

    private String largeImage;

    private String smallImage;

    @NotNull
    private Set<LocalDate> showDates;

    @NotNull
    private Set<LocalTime> schedules;

    @NotNull
    private Set<Integer> typeId;
}
