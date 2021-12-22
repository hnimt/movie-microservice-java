package fpt.trainining.movietheatre.dto.show_date;

import fpt.trainining.movietheatre.entity.Movie;
import lombok.Data;

import java.time.LocalDate;
import java.util.Collection;

@Data
public class ShowDateResponse {
    private Integer showDateId;

    private LocalDate showDate;

    private String dayName;

    private Collection<Movie> movies;
}
