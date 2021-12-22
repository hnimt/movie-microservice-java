package fpt.trainining.movietheatre.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberReq {
    private Integer score;
    private String accountId;
}
