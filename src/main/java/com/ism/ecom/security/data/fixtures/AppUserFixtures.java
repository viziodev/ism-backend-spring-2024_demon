package com.ism.ecom.security.data.fixtures;

import com.ism.ecom.data.entities.Categorie;
import com.ism.ecom.data.repositories.CategorieRepository;
import com.ism.ecom.security.data.entities.AppUser;
import com.ism.ecom.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Order(2)
public class AppUserFixtures implements CommandLineRunner {
   private final SecurityService securityService;
    @Override
    public void run(String... args) throws Exception {
        securityService.saveUser("admin","passer");
        securityService.addRoleToUser("admin","Admin");
        securityService.addRoleToUser("admin","Client");
    }
}
