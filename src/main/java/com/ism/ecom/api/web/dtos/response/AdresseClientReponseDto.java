package com.ism.ecom.api.web.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdresseClientReponseDto {
    private String quartier;
    private String ville;
    private String numVilla;
}
