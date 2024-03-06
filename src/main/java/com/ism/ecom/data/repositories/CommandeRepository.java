package com.ism.ecom.data.repositories;

import com.ism.ecom.data.entities.Client;
import com.ism.ecom.data.entities.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository  extends JpaRepository<Commande,Long> {

    Page<Commande> findCommandesByClientIdAndActiveTrue(Long id,Pageable pageable);
    Page<Commande> findCommandesByActiveTrue(Pageable pageable);
}
