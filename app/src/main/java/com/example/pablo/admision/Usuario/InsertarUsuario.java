package com.example.pablo.admision.Usuario;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pablo.admision.R;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class InsertarUsuario extends AppCompatActivity {

    EditText etrut;
    EditText etnombre;
    EditText etapellidop;
    EditText etapellidom;
    EditText ettelefono;
    EditText etemail;
    EditText etliceo;
    EditText etegreso;
    Button buguser;

    //atributos necesarios para la conexion remota
    HttpClient cliente;
    HttpPost post;
    List<NameValuePair> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_usuario);

        etrut=(EditText)findViewById(R.id.etrut);
        etnombre=(EditText)findViewById(R.id.etnombre);
        etapellidop=(EditText)findViewById(R.id.etapellidop);
        etapellidom=(EditText)findViewById(R.id.etapellidom);
        ettelefono=(EditText)findViewById(R.id.ettelefono);
        etemail=(EditText)findViewById(R.id.etemail);
        etliceo=(EditText)findViewById(R.id.etliceo);
        etegreso=(EditText)findViewById(R.id.etegreso);
        buguser=(Button)findViewById(R.id.bugusuario);


        buguser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etrut.getText().toString().equals("")){
                    Toast.makeText(InsertarUsuario.this, "DEBE COMPLETAR LOS CAMPOS", Toast.LENGTH_LONG).show();
                    etrut.requestFocus();
                }else if(etnombre.getText().toString().equals("")){
                    Toast.makeText(InsertarUsuario.this, "DEBE COMPLETAR LOS CAMPOS", Toast.LENGTH_LONG).show();
                    etnombre.requestFocus();
                }else if(etapellidop.getText().toString().equals("")){
                    Toast.makeText(InsertarUsuario.this, "DEBE COMPLETAR LOS CAMPOS", Toast.LENGTH_LONG).show();
                    etapellidop.requestFocus();
                }else if(etapellidom.getText().toString().equals("")){
                    Toast.makeText(InsertarUsuario.this, "DEBE COMPLETAR LOS CAMPOS", Toast.LENGTH_LONG).show();
                    etapellidom.requestFocus();
                }else if(ettelefono.getText().toString().equals("")){
                    Toast.makeText(InsertarUsuario.this, "DEBE COMPLETAR LOS CAMPOS", Toast.LENGTH_LONG).show();
                    ettelefono.requestFocus();
                }else if(etemail.getText().toString().equals("")){
                    Toast.makeText(InsertarUsuario.this, "DEBE COMPLETAR LOS CAMPOS", Toast.LENGTH_LONG).show();
                    etemail.requestFocus();
                }else if (etliceo.getText().toString().equals("")){
                    Toast.makeText(InsertarUsuario.this, "DEBE COMPLETAR LOS CAMPOS", Toast.LENGTH_LONG).show();
                    etliceo.requestFocus();
                }else if(etegreso.getText().toString().equals("")){
                    Toast.makeText(InsertarUsuario.this, "DEBE COMPLETAR LOS CAMPOS", Toast.LENGTH_LONG).show();
                    etegreso.requestFocus();
                }else {
                    new EnviarDatos(InsertarUsuario.this).execute();

                }
            }
        });

    }

    //Metodo Insertar los datos de Usuario
    private boolean enviarDatos() {
        cliente = new DefaultHttpClient();

        post = new HttpPost("http://192.168.0.11/Admision/WebService/InsertarUsuario.php");

        list = new ArrayList<NameValuePair>(8);
        list.add(new BasicNameValuePair("etrut", etrut.getText().toString().trim()));
        list.add(new BasicNameValuePair("etnombre", etnombre.getText().toString().trim()));
        list.add(new BasicNameValuePair("etapellidop", etapellidop.getText().toString().trim()));
        list.add(new BasicNameValuePair("etapellidom", etapellidom.getText().toString().trim()));
        list.add(new BasicNameValuePair("ettelefono", ettelefono.getText().toString().trim()));
        list.add(new BasicNameValuePair("etemail", etemail.getText().toString().trim()));
        list.add(new BasicNameValuePair("etliceo", etliceo.getText().toString().trim()));
        list.add(new BasicNameValuePair("etegreso", etegreso.getText().toString().trim()));
        try {
            post.setEntity(new UrlEncodedFormEntity(list));
            cliente.execute(post);

            return true;

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

        } catch (ClientProtocolException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return false;
    }
    //Clase que ejecuta en segundo plano
    class EnviarDatos extends AsyncTask<String, String, String> {

        private Activity context;

        EnviarDatos(Activity context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... params) {
            if (enviarDatos())
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, "PERSONA GUARDADA CON EXITO", Toast.LENGTH_LONG).show();

                        limpiarText();

                    }
                });
            else
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, "PERSONA NO GUARDADA", Toast.LENGTH_LONG).show();
                    }
                });
            return null;
        }
    }

    //Metodo para Limpiar Campos
    public void  limpiarText(){
        etrut.setText("");
        etnombre.setText("");
        etapellidop.setText("");
        etapellidom.setText("");
        ettelefono.setText("");
        etemail.setText("");
        etliceo.setText("");
        etegreso.setText("");
    }
}
