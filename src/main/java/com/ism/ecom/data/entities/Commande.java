package com.ism.ecom.data.entities;

import com.ism.ecom.data.enums.EtatCommande;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "commandes")
public class Commande extends  AbstractEntity {
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateComd;
    private Double montant;
    @Enumerated(value = EnumType.STRING)
    private EtatCommande etat;
    @Embedded
    private Adresse adresse;
    @OneToMany(mappedBy ="commande")
    private List<LigneCommande> ligneCommandes;
    @ManyToOne()
    Client client;

}
