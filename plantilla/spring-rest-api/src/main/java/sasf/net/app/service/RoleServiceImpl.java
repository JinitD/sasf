package sasf.net.app.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sasf.net.app.entity.Role;
import sasf.net.app.repository.RoleRepository;

@Service
public class RoleServiceImpl  implements RoleService{
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public Optional<Role> findById(Long id) {
		return roleRepository.findById(id);
	}

	@Override
	public List<Role> findAllEntity() {
		return roleRepository.findAll();
	}

}