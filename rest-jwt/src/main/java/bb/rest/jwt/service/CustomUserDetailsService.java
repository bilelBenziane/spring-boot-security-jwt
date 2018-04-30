package bb.rest.jwt.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import bb.rest.jwt.model.ApplicationUser;


@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		ApplicationUser applicationUser=loadApplicationUserByUsername(username);
		return new User(applicationUser.getUsername(),applicationUser.getPassword(),AuthorityUtils.createAuthorityList("ROLE_USER"));
	}
	
	public ApplicationUser loadApplicationUserByUsername(String username) {
		return new ApplicationUser("batman","pass");
	}

	

}
