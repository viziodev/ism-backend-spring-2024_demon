package com.ism.ecom.web.controllers.impl;

import com.ism.ecom.data.entities.Article;
import com.ism.ecom.data.entities.Client;
import com.ism.ecom.data.entities.Commande;
import com.ism.ecom.exceptions.EntityNotFoundException;
import com.ism.ecom.services.ArticleService;
import com.ism.ecom.services.ClientService;
import com.ism.ecom.services.CommandeService;
import com.ism.ecom.web.controllers.CommandeController;
import com.ism.ecom.web.dto.request.ArticlePanierDto;
import com.ism.ecom.web.dto.request.PanierDto;
import com.ism.ecom.web.dto.response.ArticleSimpleResponseDto;
import com.ism.ecom.web.dto.response.ClientShowReponseDto;
import com.ism.ecom.web.dto.response.CommandeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@SessionAttributes({"panier"})
public class CommandeControllerImpl implements CommandeController {
    private final CommandeService commandeService;
    private final ArticleService articleService;
    private final ClientService clientService;
    @Override
    public String listerCommandeUnClient(Model model, Long id,
                                         @RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "8") int size) {
           Page<CommandeResponseDto> commandesDto= getCommandeResponse(id,page,size);
            model.addAttribute("commandes",commandesDto.getContent());
            model.addAttribute("clientId",id);
            model.addAttribute("pages",new int[commandesDto.getTotalPages()]);
            model.addAttribute("currentPage",page);
            return "commande/commande";
    }

    @Override
    public String listerAllCommandes(Model model, int page, int size) {
         Page<CommandeResponseDto> commandesDto=getCommandeResponse(null,page,size);
          model.addAttribute("commandes",commandesDto.getContent());
          model.addAttribute("pages",new int[commandesDto.getTotalPages()]);
          model.addAttribute("clientId",null);
          model.addAttribute("currentPage",page);
        return "commande/commande";
    }

    @Override
    public String showForm(Model model,@PathVariable Long id,
                           @ModelAttribute("panier") PanierDto panier ) {
        List<Article> articlesFormComande = articleService.getArticlesFormComande();
        Client clientById = clientService.getClientById(id);
           if (clientById == null){
              return "redirect:/liste-client";
           }
            panier.setClient(ClientShowReponseDto.toDo(clientById));
            List<ArticleSimpleResponseDto> list = articlesFormComande.stream().map(article -> new ArticleSimpleResponseDto(article.getId(), article.getLibelle())).toList();
            model.addAttribute("articleSelectForm",list);
            model.addAttribute("panier",panier);
            model.addAttribute("articleForm",new ArticlePanierDto());
        return "commande/fom.add.commande";
    }

    @Override
    public String saveCommande(Model model, PanierDto panier) {
           commandeService.saveCommande(panier);
           Long id = panier.getClient().getId();
           panier=panier();
          model.addAttribute("panier",panier);
          return "redirect:/commandes/client/"+id;
    }

    private  Page<CommandeResponseDto> getCommandeResponse(Long id,int page, int size){
        Page<Commande> commandes =id==null ?
                commandeService.getAllCommande(page, size)
                : commandeService.getCommandeByClientWithPaginate(id, page, size);

        return  commandes.map(CommandeResponseDto::toDto);
    }

    @ModelAttribute("panier")
    public PanierDto panier(){
        return new PanierDto(
                new ArrayList<>(),
                0,
                null
        );
    }
}
