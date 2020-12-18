package authentication.com.authentication.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import authentication.beans.Login;


@SpringBootApplication
@ComponentScan({"authentication.beans","authentication.controller","authentication.security","authentication.service"})
public class AuthenticationSSOApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AuthenticationSSOApp.class, args);
		System.out.println("First Application");
		context.getBean(Login.class);
	}

}
