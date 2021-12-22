package fpt.trainining.movietheatre.dto.account;

import fpt.trainining.movietheatre.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Data
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
    private String jwtToken;
}
