package fpt.trainining.movietheatre.dto.member;

import fpt.trainining.movietheatre.dto.account.AccountInfoRes;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberRes {
    private Integer score;
    private AccountInfoRes accountInfoRes;
}
