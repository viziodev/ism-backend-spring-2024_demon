package com.ism.ecom.web.controllers;

import com.ism.ecom.web.dto.request.ClientCreateRequestDto;
import com.ism.ecom.web.dto.request.PanierDto;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface ClientController {
    ///client
    @GetMapping("/admin/liste-client")//End Point
    String listerClient(Model model,
                          @RequestParam(defaultValue = "0") int page,
                          @RequestParam(defaultValue = "8") int size,
                          @RequestParam( defaultValue = "") String keyword,
                          @ModelAttribute("panier") PanierDto panier);


    //@GetMapping("/")
    //String index();

     @GetMapping("/admin/form-client")
     String showForm(Model model);

    @PostMapping("/admin/save-client")
    String saveClient(ClientCreateRequestDto client, BindingResult bindingResult, RedirectAttributes redirectAttributes);
}
