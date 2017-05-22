package com.example.pablo.admision.Carrera;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pablo.admision.BaseDatos.BaseDatos;
import com.example.pablo.admision.R;

import java.util.ArrayList;

public class DetalleCarrera extends AppCompatActivity {

    private TextView nombre;
    private TextView desc;
    private TextView link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_carrera);

        nombre = (TextView) findViewById(R.id.nombre_c);
        desc = (TextView) findViewById(R.id.desc_c);
        link = (TextView) findViewById(R.id.link_c);

        nombre.setText("Informatica");
        desc.setText("Porque el Instituto Profesional (IP) Santo Tomás entrega sólidos conocimientos en tecnologías de información y comunicaciones, redes de computadores, arquitectura y diseño de aplicaciones y servicios web, tecnología relacionada con Internet, formulación, evaluación y gestión de proyectos TIC, y gestión de la información. Además, desarrolla competencias de comunicación en idioma inglés, competencias personales y valóricas de utilidad en la vida personal y laboral.");
        link.setText("WWW.SANTOTOMAS.CL");

    }
    public String[] obtenerNombre() {
        BaseDatos bd = new BaseDatos(this);
        SQLiteDatabase db = bd.getWritableDatabase();
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
