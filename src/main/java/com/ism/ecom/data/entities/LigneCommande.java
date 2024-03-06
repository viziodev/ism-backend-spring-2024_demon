package com.ism.ecom.data.entities;

import com.ism.ecom.data.enums.EtatCommande;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ligne_commandes")
public class LigneCommande extends  AbstractEntity {
    private Double montant;
    private Double quantite;
    private Double prix;
    @ManyToOne
    Article article;
    @ManyToOne
    Commande commande;

    public LigneCommande( Boolean active, Double montant, Double quantite, Double prix, Article article, Commande commande) {
        super( active);
        this.montant = montant;
        this.quantite = quantite;
        this.prix = prix;
        this.article = article;
        this.commande = commande;
    }
}
