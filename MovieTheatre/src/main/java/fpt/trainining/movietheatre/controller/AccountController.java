package fpt.trainining.movietheatre.controller;

import fpt.trainining.movietheatre.dto.ResponseHandler;
import fpt.trainining.movietheatre.dto.account.AccountInfoRes;
import fpt.trainining.movietheatre.dto.account.AccountUpdateReq;
import fpt.trainining.movietheatre.entity.Account;
import fpt.trainining.movietheatre.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity findAll() {
        List<AccountInfoRes> res = accountService.findAll();
        return ResponseHandler.generateResponse("Find successfully!", HttpStatus.OK, res);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable String id) {
        Account account = accountService.findById(id);
        return ResponseHandler.generateResponse("Find successfully!", HttpStatus.OK, account);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateAccount(@PathVariable String id, @RequestBody AccountUpdateReq accountUpdateReq) {
        AccountInfoRes result = accountService.updateAccount(id, accountUpdateReq);
        return ResponseHandler.generateResponse("Update Successfully!", HttpStatus.OK, result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccount(@PathVariable String id) {
        accountService.deleteById(id);
        return ResponseHandler.generateResponse("Delete Successfully!", HttpStatus.OK, null);
    }
}
