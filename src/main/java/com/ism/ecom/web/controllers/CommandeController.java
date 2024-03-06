package com.ism.ecom.web.controllers;

import com.ism.ecom.web.dto.request.PanierDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface CommandeController {
    @GetMapping("/commandes/client/{id}")
    String listerCommandeUnClient(Model model,@PathVariable Long id,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "8") int size);

    @GetMapping("/commandes")
    String listerAllCommandes(Model model,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "8") int size);

    @GetMapping("/form-commande/client/{id}")
    String showForm(Model model,@PathVariable Long id,@ModelAttribute("panier") PanierDto panier );
    @GetMapping("/add-commande")
    String saveCommande(Model model,@ModelAttribute("panier") PanierDto panier );
}
