package sasf.net.app.security.userdetails;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sasf.net.app.entity.Role;
import sasf.net.app.entity.Users;
import sasf.net.app.repository.RoleRepository;
import sasf.net.app.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users users = userRepository.findOneByEmail(email)
		.orElseThrow(()-> new UsernameNotFoundException("The User with email "+ email+ "do not exist"));
		Optional<Role> role = roleRepository.findById(users.getId());
		return new UserDetailsImpl(users,role.get());
	}

}
