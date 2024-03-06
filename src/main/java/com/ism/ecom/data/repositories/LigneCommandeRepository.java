package com.ism.ecom.data.repositories;

import com.ism.ecom.data.entities.Categorie;
import com.ism.ecom.data.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande,Long> {
}
