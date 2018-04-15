package com.example.rafaj.fragmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView text,tam,distancia;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text = findViewById(R.id.textId);
        distancia = findViewById(R.id.distanciaText);
        tam = findViewById(R.id.tamanioText);
        imagen = findViewById(R.id.imagen);
        Intent callingIntent = getIntent();
        String intentAction = callingIntent.getAction();
        String intentType = callingIntent.getType();

        if (Intent.ACTION_SEND.equals(intentAction) && intentType != null){

                handleReceivedText(callingIntent.getExtras());

        }

    }

    private void handleReceivedText(Bundle bundle){
        Planeta planeta = (Planeta) bundle.getSerializable("PLANETA");

        if (text != null){
            text.setText(planeta.getNombre());
            distancia.setText(planeta.getDistancia());
            tam.setText(planeta.getTamanio());
            imagen.setImageResource(planeta.getImageID());
        }
    }
}
