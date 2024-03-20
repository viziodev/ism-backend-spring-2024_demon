package com.ism.ecom.web.controllers.impl;

import com.ism.ecom.data.entities.Client;
import com.ism.ecom.data.repositories.ClientRepository;
import com.ism.ecom.services.ClientService;
import com.ism.ecom.services.impl.ClientServiceImpl;
import com.ism.ecom.web.controllers.ClientController;
import com.ism.ecom.web.dto.request.ClientCreateRequestDto;
import com.ism.ecom.web.dto.request.PanierDto;
import com.ism.ecom.web.dto.response.ClientShowReponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@SessionAttributes({"panier"})
public class ClientControllerImpl implements ClientController {
   private final ClientService clientService;

    @Override
    public String listerClient(Model model,
                               @RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "8") int size,
                               @RequestParam( defaultValue = "") String keyword,
                               @ModelAttribute("panier") PanierDto panier) {
            panier.getArticlesPanier().clear();
            panier.setTotal(0);

            Page<Client> clients = clientService.getAllClientWithPaginateAndFilter(keyword,PageRequest.of(page, size));
            Page<ClientShowReponseDto> clientsDto = clients.map(ClientShowReponseDto::toDo);
            model.addAttribute("clients",clientsDto.getContent());
            model.addAttribute("pages",new int[clientsDto.getTotalPages()]);
            model.addAttribute("currentPage",page);
            model.addAttribute("keyword",keyword);
           return "client/client";
    }
    //@Override
    //public String index() {
       // return "redirect:/liste-client";
    //}

    @Override
    public String showForm(Model model) {
        ClientCreateRequestDto clientCreateRequestDto = ClientCreateRequestDto.builder().build();
        model.addAttribute("client",clientCreateRequestDto);
        return "client/fom.add.client";
    }
    @Override
    public String saveClient(@Valid ClientCreateRequestDto clientDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            Map<String, String> errors =new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
            redirectAttributes.addFlashAttribute("mode","error");
            redirectAttributes.addFlashAttribute("errors",errors);
        }else{
            clientService.addClient(clientDto);
        }
        return "redirect:/form-client";

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
