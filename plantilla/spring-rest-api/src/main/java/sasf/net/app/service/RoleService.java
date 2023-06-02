package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import sasf.net.app.entity.Role;

public interface RoleService {
	public Optional<Role> findById(Long id);

	public List<Role> findAllRole();
}
