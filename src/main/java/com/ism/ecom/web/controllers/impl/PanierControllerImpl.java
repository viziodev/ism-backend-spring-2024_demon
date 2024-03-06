package com.ism.ecom.web.controllers.impl;

import com.ism.ecom.data.entities.Article;
import com.ism.ecom.data.repositories.ArticleRepository;
import com.ism.ecom.web.controllers.PanierController;
import com.ism.ecom.web.dto.request.ArticlePanierDto;
import com.ism.ecom.web.dto.request.PanierDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequiredArgsConstructor
@SessionAttributes({"panier"})
public class PanierControllerImpl implements PanierController {
    private final ArticleRepository articleRepository;
    @Override
    public String addProduitPanier(Model model, ArticlePanierDto articleForm, @ModelAttribute("panier")  PanierDto panier) {
        //1--Validation
        Article article = articleRepository.findById(articleForm.getIdArticle()).orElse(null);

        if (article != null) {
             articleForm.setPrix(articleForm.getPrix()==null?article.getNouveauPrix():articleForm.getPrix());
             articleForm.setLibelle(article.getLibelle());
             panier.addArticleToPanier(articleForm);
        }
        return "redirect:/form-commande/client/"+panier.getClient().getId();
    }
}
