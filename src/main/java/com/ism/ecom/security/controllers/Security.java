package com.ism.ecom.security.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;

public interface Security {
    @GetMapping("/login")
      public String login(@AuthenticationPrincipal UserDetails userDetails);
}
