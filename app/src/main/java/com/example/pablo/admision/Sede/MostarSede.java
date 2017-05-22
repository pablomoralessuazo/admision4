package com.example.pablo.admision.Sede;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pablo.admision.BaseDatos.BaseDatos;
import com.example.pablo.admision.R;

public class MostarSede extends AppCompatActivity {
    public ListView list;
    public String [] datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostar_sede);

        try {
            list = (ListView) findViewById(R.id.ListView);

            BaseDatos bd = new BaseDatos(getApplicationContext());
            datos = bd.sedeArray();

            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
            list.setAdapter(adaptador);
        }catch (Exception e){
            Toast.makeText(getBaseContext(), "Error"+ e, Toast.LENGTH_SHORT).show();
        }
        list.setClickable(true);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //ItemCliked item = adapter.getItemAtPosition(position);
                try {

                    Intent i = new Intent(MostarSede.this, DetalleSede.class);
                    //based on item add info to intent
                    startActivity(i);

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "EL Error Es: " + e, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
