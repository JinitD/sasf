package sasf.net.app.security.JWTAuthFilter;

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
import sasf.net.app.security.userdetails.UserDetailsImpl;

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
				System.out.println(e);
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
		String token =  TokenUtils
				.createToken(userDetails.getName(), userDetails.getUsername(),userDetails.getRole());
		response.addHeader("Authorization", "Bearer "+token);
		response.getWriter().flush();
		response.setStatus(200);
        response.setContentType("application/json");
		super.successfulAuthentication(request, response, chain, authResult);
	}
	
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, 
        HttpServletResponse response, AuthenticationException failed) 
        throws IOException, ServletException {
        response.getWriter().write( 
            new ObjectMapper().writeValueAsString("nada"));
        response.setStatus(401);
        response.setContentType("application/json");

    }
}
