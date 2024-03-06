package com.ism.ecom.services;

import com.ism.ecom.data.entities.Client;
import com.ism.ecom.data.entities.Commande;
import com.ism.ecom.web.dto.request.PanierDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CommandeService {
      Page<Commande> getCommandeByClientWithPaginate(Long id,int page, int size);
      Page<Commande> getAllCommande(int page, int size);
      void saveCommande(PanierDto panierDto);

}
