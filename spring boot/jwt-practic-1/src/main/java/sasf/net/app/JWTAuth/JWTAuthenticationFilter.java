package sasf.net.app.JWTAuth;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import sasf.net.app.security.AuthCredentials;
import sasf.net.app.security.TokenUtils;
import sasf.net.app.service.UserDetailsImpl;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response)
			throws AuthenticationException {
			AuthCredentials authCredentials = new AuthCredentials();
			try {
				authCredentials =  new ObjectMapper()
						.readValue(request.getReader(), AuthCredentials.class);
			} catch (IOException e) {
				// TODO: handle exception
			}
			UsernamePasswordAuthenticationToken usernamePat = 
					new UsernamePasswordAuthenticationToken(authCredentials.getEmail()
							, authCredentials.getPassword(),
							Collections.emptyList());
					
		return getAuthenticationManager().authenticate(usernamePat);
	}
	
	@Override
	protected void successfulAuthentication(
			HttpServletRequest request,
			HttpServletResponse response,
			FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		UserDetailsImpl userDetails=(UserDetailsImpl)authResult.getPrincipal();
		String token = TokenUtils
						.createToken(userDetails.getName(), userDetails.getUsername());
		response.addHeader("Authorization", "Bearer "+token);
		response.getWriter().flush();
		
		super.successfulAuthentication(request, response, chain, authResult);
	}
}
