package com.example.pasodemensajes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PaginaRespuesta extends AppCompatActivity {
    private TextView recibe;
    private EditText envia;
    private Button boton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_respuesta);

        linkElementos();
        iniciaElementos();
        permitirBotones();


    }

    private void permitirBotones() {
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent responder = new Intent();
                responder.putExtra("r0", envia.getText().toString());
                setResult(RESULT_OK,responder);
                finish();
            }
        });
    }


    private void iniciaElementos() {
        envia.setHint(R.string.Hint);
        boton.setText(R.string.boton_enviar);
        Intent siguiente = getIntent();
        recibe.setText(siguiente.getStringExtra("mE"));

    }

    private void linkElementos() {
        recibe = (TextView)findViewById(R.id.recibe);
        envia = (EditText)findViewById(R.id.escribe);
        boton = (Button)findViewById(R.id.button);

    }


}