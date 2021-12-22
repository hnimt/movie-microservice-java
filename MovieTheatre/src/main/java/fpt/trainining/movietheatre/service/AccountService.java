package fpt.trainining.movietheatre.service;

import fpt.trainining.movietheatre.dto.account.AccountInfoRes;
import fpt.trainining.movietheatre.dto.account.AccountRegisterReq;
import fpt.trainining.movietheatre.dto.account.AccountUpdateReq;
import fpt.trainining.movietheatre.entity.Account;

import java.util.List;

public interface AccountService {
    List<AccountInfoRes> findAll();
    Account findById(String accountId);
    Account findByUsername(String username);
    AccountInfoRes createAccount(AccountRegisterReq accountRegisterReq);
    AccountInfoRes updateAccount(String accountId, AccountUpdateReq accountUpdateReq);
    void deleteById(String accountId);
    Account updateRole(String accountId, String roleName);
}
