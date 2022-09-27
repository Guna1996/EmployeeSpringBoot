//package com.ideas2it.employeeProject.utils;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.ideas2it.employeeProject.model.Employee;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Date;
//
//import static com.ideas2it.employeeProject.utils.Constants.EXPIRATION_TIME;
//import static com.ideas2it.employeeProject.utils.Constants.SECRET;
//
//public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    private AuthenticationManager authenticationManager;
//
//    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//
//        setFilterProcessesUrl("/api/services/controller/user/login");
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest req,
//                                                HttpServletResponse res) throws AuthenticationException {
//        try {
//            Employee employee = new ObjectMapper()
//                    .readValue(req.getInputStream(), Employee.class);
//
//            return authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            employee.getUsername(),
//                            employee.getPassword(),
//                            new ArrayList<>())
//            );
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest req,
//                                            HttpServletResponse res,
//                                            FilterChain chain,
//                                            Authentication auth) throws IOException {
//        String token = JWT.create()
//                .withSubject(((Employee) auth.getPrincipal()).getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .sign(Algorithm.HMAC512(SECRET.getBytes()));
//
//        String body = ((User) auth.getPrincipal()).getUsername() + " " + token;
//
//        res.getWriter().write(body);
//        res.getWriter().flush();
//    }
//}