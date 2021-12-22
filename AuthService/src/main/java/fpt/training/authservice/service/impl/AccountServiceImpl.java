package fpt.training.authservice.service.impl;

import fpt.training.authservice.dto.req.AccountRegisterReq;
import fpt.training.authservice.dto.res.AccountInfoRes;
import fpt.training.authservice.entity.Account;
import fpt.training.authservice.entity.Role;
import fpt.training.authservice.entity.common.Roles;
import fpt.training.authservice.repository.AccountRepository;
import fpt.training.authservice.repository.RoleRepository;
import fpt.training.authservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final ModelMapper mapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;

    @Override
    public AccountInfoRes findById(String accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new UsernameNotFoundException("Cannot found user"));
        AccountInfoRes res = new ModelMapper().map(account, AccountInfoRes.class);
        return res;
    }

    @Override
    public void createAccount(AccountRegisterReq req) {
        Account account = mapper.map(req, Account.class);

        if (req.getRoleName() == null) {
            Role role = roleRepository.findByRoleName(Roles.CUSTOMER.roleName)
                    .orElseThrow(() -> new RuntimeException("Cannot found role name"));
            account.setRole(role);
        } else {
            Role role = roleRepository.findByRoleName(req.getRoleName())
                    .orElseThrow(() -> new RuntimeException("Cannot found role name"));;
            account.setRole(role);
        }

        account.setRegisterDate(LocalDate.now());
        account.setPassword(bCryptPasswordEncoder.encode(req.getPassword()));
        Account createdAccount = accountRepository.save(account);
    }
}
