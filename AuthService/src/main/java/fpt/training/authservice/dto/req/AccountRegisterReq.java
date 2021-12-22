package fpt.training.authservice.dto.req;

import lombok.Data;

@Data
public class AccountRegisterReq {
    private String username;
    private String password;
    private String roleName;
}
