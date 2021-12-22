package fpt.training.authservice.service;

import fpt.training.authservice.dto.req.AccountRegisterReq;
import fpt.training.authservice.dto.res.AccountInfoRes;

public interface AccountService {
    AccountInfoRes findById(String accountId);
    void createAccount(AccountRegisterReq accountRegisterReq);
}
