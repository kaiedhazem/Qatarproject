package isi.com.Qatar2022.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.com.Qatar2022.Entities.ERole;
import isi.com.Qatar2022.Entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
