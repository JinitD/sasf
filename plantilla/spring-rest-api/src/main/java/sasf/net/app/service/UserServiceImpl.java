package sasf.net.app.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sasf.net.app.entity.Role;
import sasf.net.app.entity.Users;
import sasf.net.app.repository.RoleRepository;
import sasf.net.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;

	@Override
	public Optional<Users> findOneEntityById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<Users> findAllEntity() {
		return userRepository.findAllByStatusNot("N");
	}



	@Override
	public boolean deleteEntity(Long id) {
		Optional<Users> oUser = findOneEntityById(id);
		if (!oUser.isPresent()) {
			return false;
		}
		oUser.get().setStatus("N");
		saveEntity(oUser.get());

		return true;
	}

	@Override
	public Optional<Users> findOneEntityByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findOneByEmail(email);
	}


	@Override
	public Users saveEntity(Users users) {

		try {
			Set<Role> strRoles = null;
			Long roleId =  0L;
			if(!users.getRoles().isEmpty()) {
				Role role = users.getRoles().stream().findFirst().orElse(null);
				roleId= role.getId();
			}else {
				roleId=1L;
			}
			strRoles = roleRepository.findOneRoleById(roleId);
			users.setRoles(strRoles);
			users.setStatus("A");
			users.setPassword(encoder.encode(users.getPassword()));
		} catch (Exception e) {
			System.out.println(e);
		}

		return userRepository.save(users);
	}

}
