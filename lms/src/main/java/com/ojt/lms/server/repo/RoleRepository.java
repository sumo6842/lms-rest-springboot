package com.ojt.lms.server.repo;

import com.ojt.lms.server.model.dto.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findRoleByRoleName(String name);
}
