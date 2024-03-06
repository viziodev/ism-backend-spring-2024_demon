package com.ism.ecom.web.dto.response;

import com.ism.ecom.data.entities.Adresse;
import com.ism.ecom.data.entities.Commande;
import com.ism.ecom.data.enums.EtatCommande;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommandeResponseDto {
    //Entity  Transformer en Dto
     private Date dateComd;
     private Double montant;
     private EtatCommande etat;
     private EtatCommande etatSuivant;
     private Adresse adresse;
     private Long id;
   public CommandeResponseDto(Commande commande) {


   }

   public static CommandeResponseDto toDto(Commande commande){

       EtatCommande  EtatSuivant=EtatCommande.Payer;
        if (commande.getEtat()!=EtatCommande.Payer){
           long indexEnumEtat = commande.getEtat().getIndexEnumEtat()+1;
            EtatSuivant = EtatCommande.values()[Long.valueOf(indexEnumEtat).intValue()];
        }
       return  CommandeResponseDto
               .builder()
               .id(commande.getId())
               .dateComd(commande.getDateComd())
               .montant(commande.getMontant())
               .etat(commande.getEtat())
               .etatSuivant(EtatSuivant)
               .adresse(commande.getAdresse())
               .build();
      }
}
