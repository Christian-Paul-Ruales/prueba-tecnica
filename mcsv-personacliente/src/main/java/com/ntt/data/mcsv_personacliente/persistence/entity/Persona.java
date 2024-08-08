package com.ntt.data.mcsv_personacliente.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="persona")
@Getter
@Setter
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String genero;
    private Integer edad;
    private String identificacion;
    private String dirección;
    private String teléfono;
}
