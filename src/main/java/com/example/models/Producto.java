/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.models;

import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Danie
 */
@Entity
public class Producto implements Serializable {
    private String name;
    private String marca;
    private String fecha;
    private Long id;
    @NotNull
    @Column(name = "create_at", updatable = false)
    @Temporal(TemporalType.DATE)
    private Calendar createdAt;
     @NotNull
     @Column(name = "updated_at")
     @Temporal(TemporalType.DATE)
     private Calendar updatedAt;

    public Producto() {
    }

    public Producto(String name, String marca, String fecha) {
        this.name = name;
        this.marca = marca;
        this.fecha = fecha;
    }
    
     @PreUpdate
     private void updateTimestamp() {
     this.updatedAt = Calendar.getInstance();
     }
     @PrePersist
     private void creationTimestamp() {
     this.createdAt = this.updatedAt = Calendar.getInstance();
     }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
