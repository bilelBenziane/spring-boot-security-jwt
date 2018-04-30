package bb.rest.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import bb.rest.jwt.endpoint.FirstFloorController;


@SpringBootApplication
@ComponentScan
public class AuthApp {
	
	
	public static void main(String[] args) {
		SpringApplication.run(AuthApp.class, args);
	}

}
