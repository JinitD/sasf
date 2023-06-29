package sasf.net.app.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import sasf.net.app.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

	public Set<Role> findOneRoleById(Long i);
}
