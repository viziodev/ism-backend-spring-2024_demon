package com.ism.ecom.web.dto.request;

import com.ism.ecom.data.entities.Adresse;
import com.ism.ecom.data.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientCreateRequestDto {
    private Long id;
    //AOP
     @NotBlank(message = "Le nom est obligatoire")
     private String nomComplet;
     @NotBlank(message = "Le Telephone est obligatoire")
    // @Size(min = 9, message = "Le  Telephone doit avoir au minimun 9 chiffres")
     @Pattern(regexp = "^[0-9]{9}", message = "Le  Telephone doit avoir au minimun 9 chiffres")
     private String telephone;
     private String quartier;
     private String numVilla;
    private String ville;

    //Mapper
    public  Client toEntity(){
        return Client.builder()
                .adresse(new Adresse(quartier,ville,numVilla))
                .nomComplet(nomComplet)
                .telephone(telephone)
                .build();
    }



}
