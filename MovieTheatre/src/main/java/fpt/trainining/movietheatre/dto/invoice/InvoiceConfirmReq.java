package fpt.trainining.movietheatre.dto.invoice;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Data
public class InvoiceConfirmReq {
//    private String memberId;
    private Integer addScore;
    private LocalDate bookingDate;
    private String movieId;
    private Integer scheduleId;
    private Integer showTimeId;
    private Integer status;
//    private Integer totalMoney;
    private String promotionId;
    private Boolean isUseScore;
    private String seatNamesString;
}
