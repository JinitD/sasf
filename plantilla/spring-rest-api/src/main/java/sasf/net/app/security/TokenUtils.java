package sasf.net.app.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import sasf.net.app.security.userdetails.UserDetailsImpl;

@SuppressWarnings("deprecation")
@Component
public class TokenUtils {
	  private static final Logger logger = LoggerFactory.getLogger(TokenUtils.class);

	@Value("${sasf.net.app.jwtSecret}")
	 private String aceesTokeonKey;
	@Value("${sasf.net.app.jwtExpirationMs}")
	private  Long accesTokenValiditySeconds ;


	public  String createToken(Authentication authentication) {
		Date expirationDate = new Date(System.currentTimeMillis() + accesTokenValiditySeconds);
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		
		return Jwts.builder().setSubject(userPrincipal.getUsername())
				.claim("roles", userPrincipal.getAuthorities().stream().map(s -> s.toString()).toArray())
				.setIssuedAt(new Date())
				.setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS512, aceesTokeonKey).compact();
	}

//	public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
//		try {
//			Claims claims = Jwts.parserBuilder().setSigningKey(ACCES_TOKEN_SECRET.getBytes()).build()
//					.parseClaimsJws(token).getBody();
//			String email = claims.getSubject();
//			return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
//
//		} catch (JwtException e) {
//			System.out.println(e);
//			return null;
//		}
//
//	}
	
	public String getUserNameFromJwtToken(String token) {
	    return Jwts.parserBuilder().setSigningKey(aceesTokeonKey).build().parseClaimsJws(token).getBody().getSubject();
	}

	public  boolean validateJwtToken(String authToken) {
	    try {
	    	Jwts.parserBuilder().setSigningKey(aceesTokeonKey).build().parseClaimsJws(authToken).getBody().getSubject();
	        return true;
	    } catch (JwtException e) {
	        logger.error("Invalid JWT token: {}", e.getMessage());
	    }
	    return false;
	}
	
}
