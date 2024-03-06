package com.ism.ecom.web.dto.response;

import com.ism.ecom.data.entities.Client;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientShowReponseDto {
    private Long id;
    private String nomComplet;
    private String telephone;

    public ClientShowReponseDto(Long id, String nomComplet, String telephone, String quartier, String numVilla) {
        this.id = id;
        this.nomComplet = nomComplet;
        this.telephone = telephone;
        this.quartier = quartier;
        this.numVilla = numVilla;
    }

    private String quartier;
    private String numVilla;
    private String adresseComplet;

    //Mapper
    public static  ClientShowReponseDto toDo(Client client){
        ClientShowReponseDto clientShowReponseDto = new ClientShowReponseDto(client.getId(), client.getNomComplet(),
                client.getTelephone(), client.getAdresse().getQuartier(), client.getAdresse().getNumVilla());
         clientShowReponseDto.adresseComplet();
         return clientShowReponseDto;
    }



    private  void adresseComplet(){
        adresseComplet= String.format("%s %s ",quartier,numVilla);
    }



}
