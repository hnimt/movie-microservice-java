package fpt.trainining.movietheatre.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "invoice")
@NoArgsConstructor
@Data
public class Invoice {

    @Id
    @Column(name = "invoice_id", length = 10)
    @GeneratedValue(generator = "invoice-generator")
    @GenericGenerator(
            name = "invoice-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "INV"),
            strategy = "fpt.trainining.movietheatre.generator.MyGenerator"
    )
    private String invoiceId;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "add_score", length = 10)
    private Integer addScore;

    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "schedule_show")
    private LocalDate scheduleShow;

    @Column(name = "schedule_show_time")
    private String scheduleShowTime;

    @Column(name = "status", length = 1)
    private Integer status;

    @Column(name = "total_money", length = 19)
    private Integer totalMoney;

    @Column(name = "use_score", length = 10)
    private Integer useScore;

    @Column(name = "seat")
    private String seat;
}
