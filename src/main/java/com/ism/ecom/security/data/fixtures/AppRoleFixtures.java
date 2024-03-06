package com.ism.ecom.security.data.fixtures;

import com.ism.ecom.data.entities.Categorie;
import com.ism.ecom.data.repositories.CategorieRepository;
import com.ism.ecom.security.data.entities.AppRole;
import com.ism.ecom.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Order(1)
public class AppRoleFixtures implements CommandLineRunner {
   private final SecurityService securityService;
    @Override
    public void run(String... args) throws Exception {
          securityService.saveRole("Admin");
          securityService.saveRole("Client");

    }
}
