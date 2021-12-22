package fpt.trainining.movietheatre.service.impl;

import fpt.trainining.movietheatre.dto.account.AccountInfoRes;
import fpt.trainining.movietheatre.dto.account.AccountRegisterReq;
import fpt.trainining.movietheatre.dto.account.AccountUpdateReq;
import fpt.trainining.movietheatre.entity.Account;
import fpt.trainining.movietheatre.entity.Role;
import fpt.trainining.movietheatre.entity.common.Roles;
import fpt.trainining.movietheatre.exception.ResourceNotFoundException;
import fpt.trainining.movietheatre.repository.AccountRepository;
import fpt.trainining.movietheatre.service.AccountService;
import fpt.trainining.movietheatre.service.RoleService;
import fpt.trainining.movietheatre.service.mapper.AccountMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final ModelMapper mapper;
    private final RoleService roleService;
//    private final PasswordEncoder passwordEncoder;

    @Override
    public List<AccountInfoRes> findAll() {
        return  accountRepository.findAll()
                .stream()
                .map(account -> {
                    return accountMapper.accountToAccountInfoRes(account, new AccountInfoRes());
                })
                .collect(Collectors.toList());
    }

    @Override
    public Account findById(String accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot found account!"));
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot found account!"));
    }

    @Override
    @Transactional
    public AccountInfoRes createAccount(AccountRegisterReq req) {
        Account account = accountMapper.accountRegisterReqToAccount(req, new Account());
//        account.setPassword(passwordEncoder.encode(account.getPassword()));

        if (req.getRoleName() == null) {
            Role role = roleService.findByRoleName(Roles.CUSTOMER.roleName);
            account.setRole(role);
        } else {
            Role role = roleService.findByRoleName(req.getRoleName());
            account.setRole(role);
        }

        account.setRegisterDate(LocalDate.now());
        Account createdAccount = accountRepository.save(account);
        AccountInfoRes accountInfoRes = accountMapper.accountToAccountInfoRes(createdAccount, new AccountInfoRes());
        return accountInfoRes;
    }

    @Override
    @Transactional
    public AccountInfoRes updateAccount(String accountId, AccountUpdateReq req) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        mapper.map(req, account);
        account = accountRepository.save(account);
        AccountInfoRes res = mapper.map(account, AccountInfoRes.class);
        return res;
    }

    @Override
    public void deleteById(String accountId) {
        accountRepository.deleteById(accountId);
    }

    @Override
    public Account updateRole(String accountId, String roleName) {
        Account account = findById(accountId);
        Role role = roleService.findByRoleName(roleName);
        account.setRole(role);
        return accountRepository.save(account);
    }
}
