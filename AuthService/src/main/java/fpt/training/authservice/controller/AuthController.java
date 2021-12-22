package fpt.training.authservice.controller;

import fpt.training.authservice.dto.req.AccountRegisterReq;
import fpt.training.authservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@AllArgsConstructor
public class AuthController {

    private final AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody AccountRegisterReq req) {
        accountService.createAccount(req);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created successfully!");
    }
}
