package fpt.trainining.movietheatre.dto.employee;

import fpt.trainining.movietheatre.dto.account.AccountInfoRes;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmployeeRes {
    private AccountInfoRes accountInfoRes;
}
