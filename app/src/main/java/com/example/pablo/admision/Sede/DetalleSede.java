package com.example.pablo.admision.Sede;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.pablo.admision.R;

public class DetalleSede extends AppCompatActivity {

    FloatingActionButton floubicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_sede);

        floubicacion=(FloatingActionButton)findViewById(R.id.floubicacion);
        floubicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetalleSede.this, MapsActivity.class);
                startActivity(i);
            }
        });
    }
}
