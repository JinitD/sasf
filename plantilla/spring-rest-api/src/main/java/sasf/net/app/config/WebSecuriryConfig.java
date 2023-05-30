package sasf.net.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import sasf.net.app.security.JWTAuthFilter.JWTAuthenticationFilter;
import sasf.net.app.security.JWTAuthFilter.JWTAuthorizationFilter;
import sasf.net.app.security.userdetails.UserDetailsServiceImpl;

@Configuration
public class WebSecuriryConfig {

	
	private final UserDetailsServiceImpl userDetailsService;
	
	private final JWTAuthorizationFilter jwtAuthorizationFilter;

	

	public WebSecuriryConfig(UserDetailsServiceImpl userDetailsService, JWTAuthorizationFilter jwtAuthorizationFilter) {
		super();
		this.userDetailsService = userDetailsService;
		this.jwtAuthorizationFilter = jwtAuthorizationFilter;
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) 
			throws Exception {
		JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
		jwtAuthenticationFilter.setAuthenticationManager(authManager);
		jwtAuthenticationFilter.setFilterProcessesUrl("/api/login");
		return http
				.cors()
				.and()
				.csrf()
				.disable()
				.authorizeRequests()
					.antMatchers("/api/login").permitAll()
					.antMatchers("/api/admin/**").hasRole("ADMIN")
	                .antMatchers("/api/user/**").hasAnyRole("ADMIN", "USER")
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilter(jwtAuthenticationFilter)
				.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}



	@Bean
	AuthenticationManager AuthManager(HttpSecurity http) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder()).and().build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}




}
//public static void main(String [] args) {
//System.out.println("pass: " +new BCryptPasswordEncoder().encode("jhoan"));
//}