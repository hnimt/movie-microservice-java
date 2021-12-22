package fpt.trainining.movietheatre.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Collection;

@Entity
@Table(name = "schedule")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Schedule {

    @Id
    @Column(length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scheduleId;

    @Column(unique = true)
    private LocalTime scheduleTime;

    @ManyToMany(mappedBy = "schedules")
    @JsonIgnore
    private Collection<Movie> movies;
}
