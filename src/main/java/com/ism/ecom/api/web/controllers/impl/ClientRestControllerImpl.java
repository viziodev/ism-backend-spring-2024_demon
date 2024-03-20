package com.ism.ecom.api.web.controllers.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ism.ecom.api.web.controllers.ClientRestController;
import com.ism.ecom.api.web.dtos.request.ClientCreateRestRequestDto;
import com.ism.ecom.api.web.dtos.response.ClientListeReponseDto;
import com.ism.ecom.data.entities.Client;
import com.ism.ecom.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ClientRestControllerImpl implements ClientRestController {
    private final ClientService clientService;
    @Override
    public ResponseEntity< Map<String, Object> > listerClient(int page, int size, String keyword) {

        Page<Client> clients = clientService.getAllClientWithPaginateAndFilter(keyword, PageRequest.of(page, size));
        System.out.println("listerClient");
        List<ClientListeReponseDto> clientsDto =clients.getContent()
                .stream()
                .map(ClientListeReponseDto::toDo )
                .toList();
          Map<String, Object> response = new HashMap<>();
          response.put("results", clientsDto);
          response.put("currentPage",   clients.getNumber());
          response.put("totalItems",   clients.getTotalElements());
          response.put("totalPages", clients.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public String saveClient(ClientCreateRestRequestDto client) {
        return null;
    }
}
