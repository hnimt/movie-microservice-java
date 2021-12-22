//package fpt.trainining.movietheatre.security;
//
//import fpt.trainining.movietheatre.entity.Account;
//import fpt.trainining.movietheatre.service.AccountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
//@Service
//public class UserDetailService implements UserDetailsService {
//
//    @Autowired private AccountService accountService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Account account = accountService.findByUsername(username);
//        return new User(account.getUsername(), account.getPassword(),
//                Collections.singleton(new SimpleGrantedAuthority(account.getRole().getRoleName()))
//        );
//    }
//
////    private Collection<? extends GrantedAuthority> getAuthorities(
////            Collection<Role> roles) {
////        List<GrantedAuthority> authorities
////                = new ArrayList<>();
////        for (Role role: roles) {
////            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
////        }
////        return authorities;
////    }
//}
