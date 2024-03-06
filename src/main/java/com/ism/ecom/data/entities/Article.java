package com.ism.ecom.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "articles")
public class Article extends  AbstractEntity {
    @Column(nullable = false,length = 50)
    private String libelle;
    private Double ancienPrix;
    private Double nouveauPrix;
    private Boolean promo;
    private Integer qteStock;
    private String photo;
    @OneToMany(mappedBy ="article")
    private List<LigneCommande> ligneCommandes;

}
