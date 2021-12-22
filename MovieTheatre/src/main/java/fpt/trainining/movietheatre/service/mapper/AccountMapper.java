package fpt.trainining.movietheatre.service.mapper;

import fpt.trainining.movietheatre.dto.account.AccountInfoRes;
import fpt.trainining.movietheatre.dto.account.AccountRegisterReq;
import fpt.trainining.movietheatre.entity.Account;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountMapper {

    private final ModelMapper mapper;

    public AccountInfoRes accountToAccountInfoRes(Account account, AccountInfoRes res) {
        res = mapper.map(account, AccountInfoRes.class);
        return res;
    }

    public Account accountRegisterReqToAccount(AccountRegisterReq req, Account account) {
        mapper.map(req, account);
        return account;
    }

}
