package com.example.pablo.admision.Sede;

/**
 * Created by Pablo on 15-05-2017.
 */

public class Sede {

    public int id_sede;
    public String nombre_sede;
    public String desc_sede;
    public String mision_sede;
    public String vision_sede;
    public String link_sede;

    public Sede(int id_sede, String nombre_sede, String desc_sede, String mision_sede, String vision_sede, String link_sede) {
        this.id_sede = id_sede;
        this.nombre_sede = nombre_sede;
        this.desc_sede = desc_sede;
        this.mision_sede = mision_sede;
        this.vision_sede = vision_sede;
        this.link_sede = link_sede;
    }

    public int getId_sede() {
        return id_sede;
    }

    public String getNombre_sede() {
        return nombre_sede;
    }

    public String getDesc_sede() {
        return desc_sede;
    }

    public String getMision_sede() {
        return mision_sede;
    }

    public String getVision_sede() {
        return vision_sede;
    }

    public String getLink_sede() {
        return link_sede;
    }
}
