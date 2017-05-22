package com.example.pablo.admision.Carrera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pablo.admision.BaseDatos.BaseDatos;
import com.example.pablo.admision.R;

public class InsertarCarrera extends AppCompatActivity {

    EditText etnombre_carrera;
    EditText etdesc_carrera;
    EditText etlink_carrera;
    Button bugucarrera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_carrera);
        etnombre_carrera = (EditText) findViewById(R.id.etnombre);
        etdesc_carrera=(EditText)findViewById(R.id.etdesc_carrera);
        etlink_carrera=(EditText)findViewById(R.id.etlink_carrera);
        bugucarrera=(Button)findViewById(R.id.bugu_carrera);
        bugucarrera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarCarrera();
            }
        });
    }

    public void guardarCarrera() {

        try {

            String nombrec = etnombre_carrera.getText().toString();
            String desc = etdesc_carrera.getText().toString();
            String link = etlink_carrera.getText().toString();


            BaseDatos BDA = new BaseDatos(getApplicationContext());

            BDA.ingresarCarrera(nombrec,desc,link);

            Toast.makeText(getBaseContext(), "Datos Guardados: "+ nombrec, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "EL Error Es: " + e, Toast.LENGTH_LONG).show();

        }
    }
}
