//package fpt.trainining.movietheatre.controller;
//
//import fpt.trainining.movietheatre.dto.ResponseHandler;
//import fpt.trainining.movietheatre.dto.account.AccountInfoRes;
//import fpt.trainining.movietheatre.dto.account.AccountLoginReq;
//import fpt.trainining.movietheatre.dto.account.AccountRegisterReq;
//import fpt.trainining.movietheatre.security.UserDetailService;
//import fpt.trainining.movietheatre.service.AccountService;
//import fpt.trainining.movietheatre.util.JWTUtility;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1/auth")
//@AllArgsConstructor
//public class AuthController {
//    private JWTUtility jwtUtility;
//    private AuthenticationManager authenticationManager;
//    private AccountService accountService;
//    private UserDetailService userDetailService;
//
//    @PostMapping("/register")
//    public ResponseEntity register(@RequestBody AccountRegisterReq accountRegisterReq) {
//        AccountInfoRes res = accountService.createAccount(accountRegisterReq);
//        UserDetails userDetails = userDetailService.loadUserByUsername(res.getUsername());
//        String jwtToken = jwtUtility.generateToken(userDetails);
//        res.setJwtToken(jwtToken);
//        return ResponseHandler.generateResponse("Register successfully", HttpStatus.CREATED, res);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody AccountLoginReq accountLoginReq) throws Exception {
//        authenticate(accountLoginReq.getUsername(), accountLoginReq.getPassword());
//        final UserDetails userDetails = userDetailService.loadUserByUsername(accountLoginReq.getUsername());
//        final String token = jwtUtility.generateToken(userDetails);
//        return ResponseHandler.generateResponse("Login successfully", HttpStatus.OK, token);
//    }
//
//    private void authenticate(String username, String password) throws Exception {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//    }
//
//}
