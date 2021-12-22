//package fpt.trainining.movietheatre.config;
//
//import fpt.trainining.movietheatre.entity.common.Roles;
//import fpt.trainining.movietheatre.filter.JwtFilter;
//import fpt.trainining.movietheatre.security.UserDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired private UserDetailService userDetailService;
//    @Autowired private JwtFilter jwtFilter;
//
//    private static final String[] movieAntPatterns = {"/api/v1/movie/**", "/api/v1/show-date/**", "/api/v1/schedule/**", "/api/v1/type/**"};
//    private static final String[] adminAndEmployeeAuthorities = {Roles.EMPLOYEE.roleName, Roles.ADMIN.roleName};
//
//    @Bean
//    public static PasswordEncoder passwordEncoder() {
//        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        return bCryptPasswordEncoder;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .userDetailsService(userDetailService)
//            .passwordEncoder(passwordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf()
//                .disable()
//                .authorizeRequests()
////                .antMatchers("/api/v1/role/**").hasAuthority(Roles.ADMIN.roleName)
////                .antMatchers("/api/v1/auth/**").permitAll()
////                .antMatchers("/api/v1/account/**").permitAll()
//////                .antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**").permitAll()
////                .antMatchers(HttpMethod.POST, "/api/v1/invoice/**").hasAuthority(Roles.MEMBER.roleName)
////
////                .antMatchers(HttpMethod.GET, movieAntPatterns).permitAll()
////                .antMatchers(movieAntPatterns).hasAnyAuthority(adminAndEmployeeAuthorities)
////
////                .antMatchers("/api/v1/cinema-room/**", "api/v1/seat/**").hasAnyAuthority(adminAndEmployeeAuthorities)
////
////                .antMatchers(HttpMethod.GET, "/api/v1/schedule-seat/**").permitAll()
//
//                .anyRequest().permitAll()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//    }
//
//    @Override
//    @Bean
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }
//}
