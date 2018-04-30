package bb.rest.jwt.endpoint;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/floor1")
public class FirstFloorController {
	
	@GetMapping("office1")
	public ResponseEntity<?> enterOffic1(){
		System.out.print(SecurityContextHolder.getContext().getAuthentication());
		return new ResponseEntity("U r at office 1",HttpStatus.OK);
	}
	
	@GetMapping("office2")
	@PreAuthorize("hasRole('ADMIN')")
	public String enterOffic2(){
		
		return "U r at office 2";
	}
	
	

}
