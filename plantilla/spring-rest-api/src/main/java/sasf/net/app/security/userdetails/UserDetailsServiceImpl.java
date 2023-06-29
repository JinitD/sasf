package sasf.net.app.security.userdetails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sasf.net.app.entity.Users;
import sasf.net.app.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = userRepository.findOneByUsername(username)
		.orElseThrow(()-> new UsernameNotFoundException("The User with email "+ username+ "do not exist"));
		return  UserDetailsImpl.build(users);
	}

}
