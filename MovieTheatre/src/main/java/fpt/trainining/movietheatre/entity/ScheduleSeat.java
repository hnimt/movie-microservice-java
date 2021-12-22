package fpt.trainining.movietheatre.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "schedule_seat")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScheduleSeat {

    @Id
    @Column(length = 10)
    @GeneratedValue(generator = "schedule-seat-generator")
    @GenericGenerator(
            name = "schedule-seat-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "SS"),
            strategy = "fpt.trainining.movietheatre.generator.MyGenerator"
    )
    private String scheduleSeatId;

    private String movieId;

    @Column
    private Integer showDateId;

    @Column(length = 10)
    private Integer scheduleId;

    @Column(length = 10)
    private Integer seatId;

    private String seatColumn;

    @Column(length = 10)
    private Integer seatRow;

    @Column(length = 1)
    private Integer seatStatus;

    @Column(length = 1)
    private Integer seatType;
}
