package com.example.pablo.admision.Carrera;

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

public class MostrarCarrera extends AppCompatActivity {
    public ListView list;
    public String[] datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_carrera);
        try {
            list = (ListView) findViewById(R.id.ListView);

            BaseDatos bd = new BaseDatos(getApplicationContext());
            datos = bd.carreraArray();

            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
            list.setAdapter(adaptador);

        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Error" + e, Toast.LENGTH_SHORT).show();
        }
        list.setClickable(true);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //ItemCliked item = adapter.getItemAtPosition(position);
                try {

                    Intent i = new Intent(MostrarCarrera.this, DetalleCarrera.class);
                    //based on item add info to intent
                    startActivity(i);

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "EL Error Es: " + e, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
   /* public ItemClicked getItem(int position){
        return items.get(position);
    }*/

    /*public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        seleccion = position;
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Ver " + datos[position]);
        alertDialogBuilder.setNegativeButton("Ver", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                verRegistro();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        return false;
    }

    public void verRegistro() {
        BaseDatos db = new BaseDatos(getApplicationContext());
        Carrera carrera = db.recuperarCarrera(datos[seleccion]);

        Intent i = new Intent(this, DetalleCarrera.class);
        i.putExtra("nombre_c", carrera.getNombre_carrera());
        i.putExtra("desc_c", carrera.getDescripcion_carrera());
        i.putExtra("link_c", carrera.getLink_carrera());

        startActivity(i);
    }*/


