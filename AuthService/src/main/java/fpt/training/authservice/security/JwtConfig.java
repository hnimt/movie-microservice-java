package fpt.training.authservice.security;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class JwtConfig {
    @Value("${jwt.header}")
    private String jwtHeader;

    @Value("${jwt.prefix}")
    private String jwtPrefix;

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.exp}")
    private int jwtExp;
}
