package fpt.trainining.movietheatre.dto.type;

import fpt.trainining.movietheatre.entity.Movie;
import lombok.Data;

import java.util.Collection;

@Data
public class TypeResponse {
    private Integer typeId;
    private String typeName;
    private Collection<Movie> movies;
}
