package com.ism.ecom.security.controllers;


import com.ism.ecom.security.data.entities.AppUser;
import com.ism.ecom.security.services.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class SecurityController {
    private final SecurityService service;

    @GetMapping("/")
    public String login(@AuthenticationPrincipal UserDetails userDetails)  {
        System.out.println("login: " + userDetails.getUsername());
        if(userDetails.getAuthorities()
                .stream()
                .anyMatch(role->role.getAuthority().compareTo("Admin")==0)){
            return "redirect:/admin/liste-client";
        }
        if(userDetails.getAuthorities()
                .stream()
                .anyMatch(role->role.getAuthority().compareTo("Client")==0)){
            AppUser user= service.getUserByUsername(userDetails.getUsername());
            return "redirect:/client/liste-cmde-client?id="+user.getId();
        }
        return "redirect:/login";
    }
}
