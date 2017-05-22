package com.example.pablo.admision.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pablo.admision.Carrera.Carrera;
import com.example.pablo.admision.Sede.Sede;
import com.example.pablo.admision.Usuario.Usuario;

import java.util.ArrayList;

/**
 * Created by Pablo on 20-04-2017.
 */

public class BaseDatos extends SQLiteOpenHelper {


    private static final int VERSION_BASEDATOS = 1;
    private static final String NOMBRE_BASEDATOS = "admision.sqlite";

    private static final String TABLA_USUARIO = "CREATE TABLE usuario" +
            "(rut_usuario TEXT PRIMARY KEY ,nombre_usuario TEXT,apellidop_usuario TEXT,telefono_usuario TEXT,email_usuario TEXT,liceo_usuario TEXT," +
            "egreso_usuario TEXT);";

    private static final String TABLA_CARRERA = "CREATE TABLE carrera" +
            "(id_carrera INTEGER PRIMARY KEY autoincrement,nombre_carrera TEXT,desc_carrera TEXT,link_carrera TEXT);";

    private static final String TABLA_SEDE = "CREATE TABLE sede" +
            "(id_sede INTEGER PRIMARY KEY autoincrement,nombre_sede TEXT,desc_sede TEXT,mision_sede TEXT, vision_sede TEXT, link_sede TEXT);";

    //private static final String TABLA_="CREATE TABLE"+
    //  "();";

    //Constructor de la clase


    public BaseDatos(Context context) {

        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLA_USUARIO);
        db.execSQL(TABLA_CARRERA);
        db.execSQL(TABLA_SEDE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS" + TABLA_CARRERA);
        db.execSQL("DROP TABLE IF EXISTS" + TABLA_SEDE);
        onCreate(db);
    }

    public void insertarUsuario(String rut_usuario, String nombre_usuario, String apellidop_usuario,
                                String telefono_usuario, String email_usuario, String liceo_usaurio, String egreso_usuario) {

        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
            ContentValues valores = new ContentValues();

            valores.put("rut_usuario", rut_usuario);
            valores.put("nombre_usuario", nombre_usuario);
            valores.put("apellidop_usuario", apellidop_usuario);
            valores.put("telefono_usuario", telefono_usuario);
            valores.put("email_usuario", email_usuario);
            valores.put("liceo_usuario", liceo_usaurio);
            valores.put("egreso_usuario", egreso_usuario);

            db.insert("Usuario", null, valores);
            db.close();
        }
    }

    public Usuario recuperarUsuario(String nombre_usaurio) {

        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"rut_usuario", "nombre_usuario", "apellidop_usuario", "telefono_usuario", "email_usuario", "liceo_usuario", "egreso_usuario"};
        Cursor c = db.query("usuario", valores_recuperar, "nombre_usuario='" + nombre_usaurio + "'", null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        Usuario usuario = new Usuario(c.getString(0), c.getString(1),
                c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(6));
        db.close();
        c.close();
        return usuario;
    }


    public String[] usuarioArray() {

        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"rut_usuario", "nombre_usuario", "apellidop_usuario", "telefono_usuario", "email_usuario", "liceo_usuario", "egreso_usuario"};

        ArrayList us = new ArrayList();
        Cursor cursor = db.query("usuario", valores_recuperar, null, null, null, null, null, null);
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            //String captura[] = cursor.getString(1);
            us.add(cursor.getString(1));

        }
        String[] usuarr = (String[]) us.toArray(new String[us.size()]);

        return usuarr;
    }

    public void ingresarCarrera(String nombre_carrera, String desc_carrera, String link_carrera) {

        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
            ContentValues valores = new ContentValues();

            valores.put("nombre_carrera", nombre_carrera);
            valores.put("desc_carrera", desc_carrera);
            valores.put("link_carrera", link_carrera);

            db.insert("Carrera", null, valores);
            db.close();
        }
    }

    public Carrera recuperarCarrera(String nombre_carrera) {

        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"id_carrera", "nombre_carrera", "desc_carrera", "link_carrera"};
        Cursor c = db.query("carrera", valores_recuperar, "nombre_carrera='" + nombre_carrera + "'", null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        Carrera carrera = new Carrera(c.getInt(0), c.getString(1),
                c.getString(2), c.getString(3));
        db.close();
        c.close();

        return carrera;
    }

    public String[] carreraArray() {

        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"id_carrera", "nombre_carrera", "desc_carrera", "link_carrera"};

        ArrayList ca = new ArrayList();
        Cursor c = db.query("carrera", valores_recuperar, null, null, null, null, null);
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            //String captura[] = cursor.getString(1);
            ca.add(c.getString(1));

        }
        String[] cararr = (String[]) ca.toArray(new String[ca.size()]);

        return cararr;
    }

    public void ingresarSede(String nombre_sede, String desc_sede, String mision_sede,
                             String vision_sede, String link_sede) {

        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
            ContentValues valores = new ContentValues();

            valores.put("nombre_sede", nombre_sede);
            valores.put("desc_sede", desc_sede);
            valores.put("mision_sede", mision_sede);
            valores.put("vision_sede", vision_sede);
            valores.put("link_sede", link_sede);

            db.insert("Sede", null, valores);
            db.close();
        }

    }

    public Sede recuperarSede(String nombre_sede) {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"id_sede", "nombre_sede", "desc_sede", "mision_sede", "vision_sede", "link_sede"};

        Cursor c = db.query("sede", valores_recuperar, "nombre_sede='" + nombre_sede + "'", null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        Sede sede = new Sede(c.getInt(0), c.getString(1),
                c.getString(2), c.getString(3), c.getString(4), c.getString(5));
        db.close();
        c.close();
        return sede;

    }

    public String[] sedeArray() {

        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"id_sede", "nombre_sede", "desc_sede", "mision_sede", "vision_sede", "link_sede"};

        ArrayList se = new ArrayList();
        Cursor c = db.query("sede", valores_recuperar, null, null, null, null, null);
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {

            se.add(c.getString(1));

        }
        String[] sedearr = (String[]) se.toArray(new String[se.size()]);

        return sedearr;
    }



    public String[] obtenerNombre() {

        SQLiteDatabase db = getWritableDatabase();
        String consulta="SELECT nombre_carrera FROM carrera Where nombre_carrera=Informatica";
        db.execSQL(consulta);
        //guarda los datos
        ArrayList completo = new ArrayList();
        //recorre los datos
        Cursor cursor = db.query("carrera", new String[]{consulta}, null,null,null,null,null);

        for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()) {

            completo.add(cursor.getString(1));

        }
        String[]completoarr = (String[])completo.toArray(new String[completo.size()]);

        return completoarr;
    }



}
