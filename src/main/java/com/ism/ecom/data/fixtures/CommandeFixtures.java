package com.ism.ecom.data.fixtures;

import com.ism.ecom.data.entities.Adresse;
import com.ism.ecom.data.entities.Client;
import com.ism.ecom.data.entities.Commande;
import com.ism.ecom.data.enums.EtatCommande;
import com.ism.ecom.data.repositories.ClientRepository;
import com.ism.ecom.data.repositories.CommandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Order(Ordered.LOWEST_PRECEDENCE)
public class CommandeFixtures implements CommandLineRunner {
    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 20; i++) {
             Client client=clientRepository.findClientByTelephoneAndActiveTrue("77100101"+i);
             if(client!=null) {
              for (int j = 0; j < 5; j++) {
                   Commande commande = new Commande();
                   commande.setDateComd(new Date());
                   commande.setMontant(100000.0);
                   commande.setActive(j % 2 == 0);
                  Adresse adresse;
                  if(j % 2==0){
                       adresse = new Adresse();
                       adresse.setNumVilla("Villa 000"+j);
                       adresse.setVille(j%2==0?"Thies ":"Dakar");
                       adresse.setQuartier("Quartier 000"+j);
                      commande.setEtat(EtatCommande.Encours);
                   }else{
                      adresse=client.getAdresse();
                      commande.setEtat(EtatCommande.Terminer);
                  }
                    commande.setAdresse(adresse);
                    commande.setClient(client);
                    commandeRepository.save(commande);
               }
             }

        }
    }
}
