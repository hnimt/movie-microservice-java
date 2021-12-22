package fpt.trainining.movietheatre.dto.promotion;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PromotionReq {
    private String detail;
    private Integer discountLevel;
    private LocalDate endTime;
    private String image;
    private LocalDate startTime;
    private String title;
}
