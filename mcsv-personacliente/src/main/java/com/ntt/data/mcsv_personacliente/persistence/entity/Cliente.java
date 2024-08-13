package com.ntt.data.mcsv_personacliente.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="cliente")
public class Cliente extends Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String contrasena;
    private Boolean estado;


}
