package com.ism.ecom.data.repositories;

import com.ism.ecom.data.entities.Categorie;
import com.ism.ecom.data.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
}
