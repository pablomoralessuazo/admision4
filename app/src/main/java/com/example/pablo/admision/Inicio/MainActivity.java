package com.example.pablo.admision.Inicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.Toast;



import com.example.pablo.admision.Carrera.InsertarCarrera;
import com.example.pablo.admision.Carrera.MostrarCarrera;

import com.example.pablo.admision.R;

import com.example.pablo.admision.Sede.InsertarSede;
import com.example.pablo.admision.Sede.MapsActivity;
import com.example.pablo.admision.Sede.MostarSede;
import com.example.pablo.admision.Usuario.InsertarUsuario;

public class MainActivity extends AppCompatActivity {
    Button buguser;
    Button bugsede;
    Button bumsede;
    Button bumubicacion;
    Button bugcarrera;
    Button bumcarrera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buguser=(Button)findViewById(R.id.guardaruser);
        buguser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InsertarUsuario.class);
                startActivity(intent);
            }
        });
        try{
        bugsede=(Button)findViewById(R.id.guardarsede);
        bugsede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InsertarSede.class);
                startActivity(intent);
            }
        });}catch (Exception e){
            Toast.makeText(getApplicationContext(),"Error"+e,Toast.LENGTH_LONG).show();
        }


        bumsede=(Button)findViewById(R.id.mostrarsede);
        bumsede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MostarSede.class);
                startActivity(intent);
            }
        });

        bugcarrera=(Button)findViewById(R.id.guardarcarrera);
        bugcarrera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, InsertarCarrera.class);
                startActivity(intent);
            }
        });

        bumcarrera=(Button)findViewById(R.id.mostrarcarrera);
        bumcarrera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MostrarCarrera.class);
                startActivity(intent);
            }
        });

        bumubicacion=(Button)findViewById(R.id.ubicacion);
        bumubicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}
