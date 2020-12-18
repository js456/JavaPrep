package authentication.controller;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TestTokenController {
	
    @RequestMapping(method = RequestMethod.POST)
    public String testToken() {

        System.out.println("Inside sign in controller");
        try {
        	
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
        return "Recogniged";
    }

}
