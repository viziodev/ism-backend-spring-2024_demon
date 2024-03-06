package com.ism.ecom.security.data.reporitories;

import com.ism.ecom.security.data.entities.AppRole;
import com.ism.ecom.security.data.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
      AppUser findByUsername(String username);
}
