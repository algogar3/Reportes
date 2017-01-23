/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alberto.di;

/**
 *
 * @author dam2
 */
public class Participante {
    // ATRIBUTOS
    private int id;
    private String nombre;
    private String username;
    private String password;
    private int puntos;

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    private String comentarios;

    public Participante(int id, String nombre, String username, String password, String comentarios) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.comentarios = comentarios;
    }
    
        public Participante(String nombre, String username, String password, String comentarios) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.comentarios = comentarios;
    }
        
        public Participante(String nombre, String username, String password, int puntos, String comentarios) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.puntos = puntos;
        this.comentarios = comentarios;
    }
    
    public Participante(){}

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    
}


