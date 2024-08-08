package com.ntt.data.mcsv_personacliente.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cliente")
@Getter
@Setter
public class Cliente extends Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cliente_id")
    private String clienteId;
    private String contrasena;
    private Boolean estado;

}
