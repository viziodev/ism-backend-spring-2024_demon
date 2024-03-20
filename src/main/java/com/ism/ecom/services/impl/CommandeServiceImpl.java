package com.ism.ecom.services.impl;

import com.ism.ecom.data.entities.Article;
import com.ism.ecom.data.entities.Client;
import com.ism.ecom.data.entities.Commande;
import com.ism.ecom.data.entities.LigneCommande;
import com.ism.ecom.data.enums.EtatCommande;
import com.ism.ecom.data.repositories.ArticleRepository;
import com.ism.ecom.data.repositories.ClientRepository;
import com.ism.ecom.data.repositories.CommandeRepository;
import com.ism.ecom.data.repositories.LigneCommandeRepository;
import com.ism.ecom.exceptions.EntityNotFoundException;
import com.ism.ecom.services.CommandeService;
import com.ism.ecom.web.dto.request.PanierDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandeServiceImpl implements CommandeService {
    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;
    private final ArticleRepository articleRepository;
    private final LigneCommandeRepository ligneCommandeRepository;
    @Override
    public Page<Commande> getCommandeByClientWithPaginate(Long id,int page, int size) {
        return commandeRepository.findCommandesByClientIdAndActiveTrue(id, PageRequest.of(page, size));
    }

    @Override
    public Page<Commande> getAllCommande(int page, int size) {
        return commandeRepository.findCommandesByActiveTrue( PageRequest.of(page, size));
    }


    @Override
    public void saveCommande(PanierDto panierDto) {
        Client client = clientRepository.findById(panierDto.getClient().getId())
                .orElseThrow(()->new EntityNotFoundException("Client n'existe pas"));

            Commande commande = new Commande(
                   new Date(),
                   panierDto.getTotal(),
                   EtatCommande.Encours,
                   null,
                   null,
                   client
              );
                commande.setActive(true);
             commandeRepository.save(commande);
                List<LigneCommande> ligneCommande = panierDto.getArticlesPanier().stream().map(
                   articlePanierDto -> {
                       Article article = articleRepository.findById(articlePanierDto.getIdArticle())
                               .orElseThrow(()->new EntityNotFoundException("article n'existe pas"));
                          return new LigneCommande(
                                  articlePanierDto.getMontant(),
                                  articlePanierDto.getQuantite(),
                                  articlePanierDto.getPrix(),
                                  article,
                                  commande
                          );
                   }).toList();
                 ligneCommandeRepository.saveAllAndFlush(ligneCommande);

           }




}
