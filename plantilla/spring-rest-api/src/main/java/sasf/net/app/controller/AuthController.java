package sasf.net.app.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import sasf.net.app.entity.Users;
import sasf.net.app.payload.JwtResponse;
import sasf.net.app.payload.LoginRequest;
import sasf.net.app.security.TokenUtils;
import sasf.net.app.security.userdetails.UserDetailsImpl;
import sasf.net.app.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private UserService entityService;

	@Autowired
	TokenUtils tokenUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenUtils.createToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		if(userDetails.getStatus().equalsIgnoreCase("N")) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
		}
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		HttpHeaders headers = new HttpHeaders();

		headers.add("Authorization", "Bearer " + jwt);
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers)
				.body(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
						userDetails.getEmail(), userDetails.getName(),
						userDetails.getLastname(), userDetails.getStatus(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody Users userRegister) {
		return ResponseEntity.status(HttpStatus.CREATED).body(entityService.saveEntity(userRegister));
	}
	

}
