package com.ism.ecom.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "categories")
public class Categorie extends  AbstractEntity {
    @Column(unique = true,nullable = false,length = 50)
    private String libelle;

}
