package bb.rest.jwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import bb.rest.jwt.service.CustomUserDetailsService;



@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

		private final CustomUserDetailsService customUserDetailsService;
	
		@Autowired
		public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
			this.customUserDetailsService=customUserDetailsService;
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception{
			http.cors().and().csrf().disable().authorizeRequests()
				.antMatchers(HttpMethod.POST,"/sign_up").permitAll()
				.antMatchers("/*/floor1/**").hasRole("USER")
				.antMatchers("/*/floor2/**").hasRole("ADMIN")
				.and()
				.httpBasic();
		}
}
