package com.example.pablo.admision.Sede;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pablo.admision.BaseDatos.BaseDatos;
import com.example.pablo.admision.R;

public class InsertarSede extends AppCompatActivity {

    EditText etnombre_sede;
    EditText etdesc_sede;
    EditText etmision_sede;
    EditText etvision_sede;
    EditText etlink_sede;
    Button bugu_sede;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_sede);

        etnombre_sede=(EditText)findViewById(R.id.etnombre_sede);
        etdesc_sede =(EditText)findViewById(R.id.etdesc_carrera);
        etmision_sede= (EditText)findViewById(R.id.etmision_sede);
        etvision_sede= (EditText)findViewById(R.id.etvision_sede);
        etlink_sede=(EditText)findViewById(R.id.etlink_sede);
        bugu_sede=(Button)findViewById(R.id.bugu_sede);
        bugu_sede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarSede();
            }
        });
    }
    public void guardarSede(){
        try {

            String nombre_sede = etnombre_sede.getText().toString();
            String desc_sede = etdesc_sede.getText().toString();
            String mision_sede = etmision_sede.getText().toString();
            String vision_sede = etvision_sede.getText().toString();
            String link_sede = etlink_sede.getText().toString();


            BaseDatos BDA = new BaseDatos(getApplicationContext());

            BDA.ingresarSede(nombre_sede,desc_sede,mision_sede,vision_sede, link_sede);

            Toast.makeText(getBaseContext(), "Datos Guardados: "+ nombre_sede, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "EL Error Es: " + e, Toast.LENGTH_LONG).show();

        }
    }

}
