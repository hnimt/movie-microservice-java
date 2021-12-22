package fpt.trainining.movietheatre.dto.account;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AccountUpdateReq {
    private String address;
    private String password;
    private LocalDate dateOfBirth;
    private String email;
    private String fullName;
    private String gender;
    private String identityCard;
    private String image;
    private String phoneNumber;
    private Integer status;
    private String roleName;
}
