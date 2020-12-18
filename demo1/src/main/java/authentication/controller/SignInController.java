package authentication.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import authentication.beans.Login;
import authentication.security.InvalidJwtAuthenticationException;
import authentication.security.JwtTokenProvider;
import io.jsonwebtoken.JwtException;


@RequestMapping("/signin")
@RestController
public class SignInController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;
    
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity signin(@RequestBody Login data) {

        System.out.println("Inside sign in controller");
        try {
            String username = data.getUsername();
            String password = data.getPassword();
            String token=null;
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            SecurityContext sc = SecurityContextHolder.getContext();
            sc.setAuthentication(auth);
			/*
			 * String token=null; if(apiResponse.getStatus()== HttpStatus.OK){ token =
			 * jwtTokenProvider.createToken(username, Arrays.asList("User"));
			 * 
			 * }
			 */
            token = jwtTokenProvider.createToken(username, Arrays.asList("User"));
            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
        catch (JwtException | IllegalArgumentException e) {
            throw new InvalidJwtAuthenticationException("Expired or invalid JWT token");
            
        }
    }
}
