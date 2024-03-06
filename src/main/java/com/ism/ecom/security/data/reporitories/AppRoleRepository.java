package com.ism.ecom.security.data.reporitories;

import com.ism.ecom.security.data.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole getByRoleName(String roleName);
}
