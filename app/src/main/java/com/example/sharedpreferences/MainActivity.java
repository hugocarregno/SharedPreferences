package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvUsuario, tvEdad;
    private Button btnGuardar, btnLeer;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvUsuario= findViewById(R.id.tvUsuario);
        tvEdad = findViewById(R.id.tvEdad);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp = getSharedPreferences("datos",0);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("usuario","juanperez");
                editor.putInt("edad",22);
                editor.commit();
            }
        });
        btnLeer = findViewById(R.id.btnLeer);
        btnLeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp = getSharedPreferences("datos",0);
                String usuario = sp.getString("usuario","-1");
                int edad = sp.getInt("edad",-1);
                tvUsuario.setText(usuario);
                tvEdad.setText(""+10);
            }
        });

    }
}
