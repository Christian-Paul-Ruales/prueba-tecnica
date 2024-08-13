package com.ntt.data.mcsv_personacliente.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CollectionId;

import java.io.Serializable;
@Data
@MappedSuperclass
public class Persona {
    @Column(name = "persona_id")
    private String personaId;
    private String nombre;
    private String genero;
    private Integer edad;
    private String identificacion;
    private String direccion;
    private String telefono;


}
