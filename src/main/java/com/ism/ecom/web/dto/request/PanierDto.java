package com.ism.ecom.web.dto.request;

import com.ism.ecom.web.dto.response.ClientShowReponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PanierDto {
    private List<ArticlePanierDto> articlesPanier ;
    private double total=0.0;
    private ClientShowReponseDto client;
    public void addArticleToPanier(ArticlePanierDto article){
         int i = articlesPanier.indexOf(article);
         double montant=0;
         if (i != -1){
                 ArticlePanierDto articleGetPanier= articlesPanier.get(i);
                 articleGetPanier.calculNewQte(article.getQuantite());
                 articleGetPanier.calculMontant(article.getQuantite()*articleGetPanier.getPrix());
                 total+=article.getQuantite()*articleGetPanier.getPrix();
           }else {
              article.setMontant(article.getPrix()*article.getQuantite());
              articlesPanier.add(article);
              total+=article.getMontant();
          }
    }
}
