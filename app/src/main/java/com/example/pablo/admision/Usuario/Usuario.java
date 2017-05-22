package com.example.pablo.admision.Usuario;

/**
 * Created by Pablo on 20-04-2017.
 */

public class Usuario {
    public String rut_usuario;
    public String nombre_usuario;
    public String apellidop_usuario;
    public String telefono_usuario;
    public String email_usuario;
    public String liceo_usuario;
    public String egreso_usuario;

    public Usuario(String rut_usuario, String nombre_usuario, String apellidop_usuario, String telefono_usuario, String email_usuario, String liceo_usuario, String egreso_usuario) {
        this.rut_usuario = rut_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellidop_usuario = apellidop_usuario;
        this.telefono_usuario = telefono_usuario;
        this.email_usuario = email_usuario;
        this.liceo_usuario = liceo_usuario;
        this.egreso_usuario = egreso_usuario;
    }

    public String getRut_usuario() {
        return rut_usuario;
    }

    public void setRut_usuario(String rut_usuario) {
        this.rut_usuario = rut_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellidop_usuario() {
        return apellidop_usuario;
    }

    public void setApellidop_usuario(String apellidop_usuario) {
        this.apellidop_usuario = apellidop_usuario;
    }

    public String getTelefono_usuario() {
        return telefono_usuario;
    }

    public void setTelefono_usuario(String telefono_usuario) {
        this.telefono_usuario = telefono_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getLiceo_usuario() {
        return liceo_usuario;
    }

    public void setLiceo_usuario(String liceo_usuario) {
        this.liceo_usuario = liceo_usuario;
    }

    public String getEgreso_usuario() {
        return egreso_usuario;
    }

    public void setEgreso_usuario(String egreso_usuario) {
        this.egreso_usuario = egreso_usuario;
    }
}
