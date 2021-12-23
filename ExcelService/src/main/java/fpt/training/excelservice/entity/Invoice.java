package fpt.training.excelservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "invoice")
@NoArgsConstructor
@Data
public class Invoice {

    @Id
    private String invoiceId;

    @Column(name = "account_id")
    private String accountId;

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
