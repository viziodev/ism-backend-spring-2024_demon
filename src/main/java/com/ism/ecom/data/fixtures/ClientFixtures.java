package com.ism.ecom.data.fixtures;

import com.ism.ecom.data.entities.Adresse;
import com.ism.ecom.data.entities.Client;
import com.ism.ecom.data.repositories.ClientRepository;
import com.ism.ecom.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(3)
public class ClientFixtures implements CommandLineRunner {
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final SecurityService securityService;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 20; i++) {
                 Client client=new Client();
                 client.setNomComplet("Nom et Prenom"+i);
                 client.setTelephone("77100101"+i);
                 Adresse adresse = new Adresse();
                 adresse.setNumVilla("Villa 000"+i);
                 adresse.setVille(i%2==0?"Thies ":"Dakar");
                 adresse.setQuartier("Quartier 000"+i);
                 client.setAdresse(adresse);
                 client.setActive(i % 2 == 0);
                 client.setPassword(passwordEncoder.encode("passer"));
                 client.setUsername("client"+i);
                 clientRepository.save(client);
                 securityService.addRoleToUser("client"+i,"Client");
        }
    }
}
