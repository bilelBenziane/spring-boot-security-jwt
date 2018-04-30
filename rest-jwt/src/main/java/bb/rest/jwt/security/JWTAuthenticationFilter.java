package bb.rest.jwt.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import bb.rest.jwt.model.ApplicationUser;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	@Override 
	//{"username","batman";"password","pass"}
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		try {
			ApplicationUser applicationUser=new ObjectMapper().readValue(request.getInputStream(),ApplicationUser.class);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
