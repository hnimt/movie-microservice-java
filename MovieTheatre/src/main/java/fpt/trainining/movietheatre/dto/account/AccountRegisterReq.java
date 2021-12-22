package fpt.trainining.movietheatre.dto.account;

import fpt.trainining.movietheatre.entity.Account;
import fpt.trainining.movietheatre.entity.Role;
import fpt.trainining.movietheatre.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountRegisterReq {
    private String username;
    private String password;
    private String roleName;
}
