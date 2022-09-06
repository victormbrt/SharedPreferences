package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private EditText usuario,clave;
  private TextView nombre, pass;
  Button Save, Load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     usuario = (EditText) findViewById(R.id.edt_nombre);
     clave = (EditText) findViewById(R.id.edt_clave);
     nombre = (TextView) findViewById(R.id.txt_nombre);
     pass = (TextView) findViewById(R.id.txt_clave);
     Save = (Button)  findViewById(R.id.btn_guardar);
     Load = (Button) findViewById(R.id.btn_recuperar);


     Load.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
             nombre.setText(preferences.getString("user", " "));
             pass.setText(preferences.getString("pass", " "));
         }
     });

     Save.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
           SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
           SharedPreferences.Editor Objectoeditor = preferencias.edit();
           Objectoeditor.putString("user", usuario.getText().toString());
           Objectoeditor.putString("pass", clave.getText().toString());
           Objectoeditor.commit();
         }
     });


     SharedPreferences Preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);

     usuario.setText(Preferences.getString("user"," "));
     clave.setText(Preferences.getString("pass", " "));














    }
}