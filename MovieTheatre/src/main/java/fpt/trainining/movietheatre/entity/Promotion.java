package fpt.trainining.movietheatre.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "promotion")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Promotion {

    @Id
    @Column(length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer promotionId;
    private String detail;

    @Column(length = 10)
    private Integer discountLevel;
    private LocalDate endTime;
    private String image;
    private LocalDate startTime;
    private String title;
}
