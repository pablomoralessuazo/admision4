package com.example.pablo.admision.Notificacion;

/**
 * Created by Pablo on 24-04-2017.
 */

public class Notificacion {

    public int id_notificacion;
    public String nombre_notificacion;
    public String desc_notificacion;

    public Notificacion(int id_notificacion, String nombre_notificacion, String desc_notificacion) {
        this.id_notificacion = id_notificacion;
        this.nombre_notificacion = nombre_notificacion;
        this.desc_notificacion = desc_notificacion;
    }

    public int getId_notificacion() {
        return id_notificacion;
    }

    public void setId_notificacion(int id_notificacion) {
        this.id_notificacion = id_notificacion;
    }

    public String getNombre_notificacion() {
        return nombre_notificacion;
    }

    public void setNombre_notificacion(String nombre_notificacion) {
        this.nombre_notificacion = nombre_notificacion;
    }

    public String getDesc_notificacion() {
        return desc_notificacion;
    }

    public void setDesc_notificacion(String desc_notificacion) {
        this.desc_notificacion = desc_notificacion;
    }
}
