package com.ism.ecom.security.services;

import com.ism.ecom.security.data.entities.AppRole;
import com.ism.ecom.security.data.entities.AppUser;

public interface SecurityService {
    AppUser getUserByUsername(String username);
    AppUser saveUser(String username,String password);
    AppRole saveRole(String roleName);
    void addRoleToUser(String username,String roleName);
    void removeRoleToUser(String username,String roleName);
}
