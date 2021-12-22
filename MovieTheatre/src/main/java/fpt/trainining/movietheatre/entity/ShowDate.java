package fpt.trainining.movietheatre.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "show_dates")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShowDate {
    @Id
    @Column(length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showDateId;

    @Column(unique = true)
    private LocalDate showDate;

    private String dayName;

    @ManyToMany(mappedBy = "showDates")
    @JsonIgnore
    private Collection<Movie> movies;

    public ShowDate(LocalDate showDate, String dayName) {
        this.showDate = showDate;
        this.dayName = dayName;
    }
}
