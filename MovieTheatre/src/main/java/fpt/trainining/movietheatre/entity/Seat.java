package fpt.trainining.movietheatre.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(
        name = "seat",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"seat_column", "seat_row", "cinema_room_id"})}
)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Seat {

    @Id
    @Column(length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;

    @ManyToOne
    @JoinColumn(name = "cinema_room_id")
    private CinemaRoom cinemaRoom;

    @Column(name = "seat_column")
    private String seatColumn;

    @Column(name = "seat_row", length = 10)
    private Integer seatRow;

    @Column(length = 1)
    private Integer seatStatus;

    @Column(length = 1)
    private Integer seatType;
}
