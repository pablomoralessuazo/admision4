package com.example.pablo.admision.Carrera;

/**
 * Created by Pablo on 20-04-2017.
 */

public class Carrera {

    public int id_carrera;
    public String nombre_carrera;
    public String descripcion_carrera;
    public String link_carrera;

    public Carrera(int id_carrera, String nombre_carrera, String descripcion_carrera, String link_carrera) {
        this.id_carrera = id_carrera;
        this.nombre_carrera = nombre_carrera;
        this.descripcion_carrera = descripcion_carrera;
        this.link_carrera = link_carrera;
    }


    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public  String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }

    public String getDescripcion_carrera() {
        return descripcion_carrera;
    }

    public void setDescripcion_carrera(String descripcion_carrera) {
        this.descripcion_carrera = descripcion_carrera;
    }

    public String getLink_carrera() {
        return link_carrera;
    }

    public void setLink_carrera(String link_carrera) {
        this.link_carrera = link_carrera;
    }
}
