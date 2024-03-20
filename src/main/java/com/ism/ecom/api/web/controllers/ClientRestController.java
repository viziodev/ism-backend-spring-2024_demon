package com.ism.ecom.api.web.controllers;

import com.ism.ecom.api.web.dtos.request.ClientCreateRestRequestDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


public interface ClientRestController {
    @GetMapping("/api/clients")//End Point
    ResponseEntity<Map<String, Object>> listerClient(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "5") int size,
                                                     @RequestParam( defaultValue = "") String keyword
                       );
    @PostMapping("/api/clients")
    String saveClient(@Valid @RequestBody ClientCreateRestRequestDto client);
}
