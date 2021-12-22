package fpt.training.authservice.dto.res;

import fpt.training.authservice.entity.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AccountInfoRes {
    private String username;
    private String address;
    private LocalDate dateOfBirth;
    private String email;
    private String fullName;
    private String gender;
    private String identityCard;
    private String image;
    private String phoneNumber;
    private LocalDate registerDate;
    private Role role;
    private Integer status;
}
