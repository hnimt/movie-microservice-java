package fpt.training.zuulgateway.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class JwtTokenAuthorizationFilter extends OncePerRequestFilter {

   private final JwtConfig jwtConfig;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        String header = req.getHeader(jwtConfig.getJwtHeader());

        if(header == null || !header.startsWith(jwtConfig.getJwtPrefix())) {
            chain.doFilter(req, res);  		// If not valid, go to the next filter.
            return;
        }

        String token = header.replace(jwtConfig.getJwtPrefix(), "");

        try {
             Claims claims = Jwts.parser()
                     .setSigningKey(jwtConfig.getJwtSecret().getBytes())
                     .parseClaimsJws(token)
                     .getBody();

             String username = claims.getSubject();
             if (username != null) {
                 List<String> authorities = (List<String>) claims.get("authorities");

                 UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                         username, null, authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));

                 SecurityContextHolder.getContext().setAuthentication(authenticationToken);
             }
        } catch (Exception e) {
            SecurityContextHolder.clearContext();
        }

        chain.doFilter(req, res);
    }
}
