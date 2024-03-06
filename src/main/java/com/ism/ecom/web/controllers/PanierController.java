package com.ism.ecom.web.controllers;

import com.ism.ecom.web.dto.request.ArticlePanierDto;
import com.ism.ecom.web.dto.request.ClientCreateRequestDto;
import com.ism.ecom.web.dto.request.PanierDto;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface PanierController {
    @PostMapping("/add-panier")
    String addProduitPanier(Model model, @Valid ArticlePanierDto articleForm,@ModelAttribute("panier") PanierDto panier);
}
