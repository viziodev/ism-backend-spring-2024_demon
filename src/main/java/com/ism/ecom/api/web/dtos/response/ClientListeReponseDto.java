package com.ism.ecom.api.web.dtos.response;

import com.ism.ecom.data.entities.Client;
import com.ism.ecom.web.dto.response.ClientShowReponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientListeReponseDto {
    private Long id;
    private String nomComplet;
    private String telephone;
    private AdresseClientReponseDto adresse;

    public static ClientListeReponseDto toDo(Client client){
        return ClientListeReponseDto
                .builder()
                .id(client.getId())
                .nomComplet(client.getNomComplet())
                .telephone(client.getTelephone())
                .adresse(AdresseClientReponseDto
                        .builder()
                        .ville(client.getAdresse().getVille())
                        .numVilla(client.getAdresse().getNumVilla())
                        .quartier(client.getAdresse().getQuartier())
                        .build())
                .build();
    }








}
