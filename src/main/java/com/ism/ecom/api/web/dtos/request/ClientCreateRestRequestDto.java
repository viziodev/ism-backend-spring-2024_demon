package com.ism.ecom.api.web.dtos.request;

import com.ism.ecom.data.entities.Adresse;
import com.ism.ecom.data.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ClientCreateRestRequestDto {
    private Long id;
     @NotBlank(message = "Le nom est obligatoire")
     private String nomComplet;
     @NotBlank(message = "Le Telephone est obligatoire")
     @Pattern(regexp = "^[0-9]{9}", message = "Le  Telephone doit avoir au minimun 9 chiffres")
     private String telephone;
     private String quartier;
     private String numVilla;
    private String ville;

}
