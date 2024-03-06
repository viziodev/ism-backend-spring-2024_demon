package com.ism.ecom.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Adresse  {
    private String quartier;
    private String ville;
    private String numVilla;

    @Override
    public String toString() {
        return
                         ville + " | "  +
                        quartier +  " | "  +
                        numVilla
                ;
    }

}
