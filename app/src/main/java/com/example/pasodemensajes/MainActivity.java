package com.example.pasodemensajes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText textoAIntroducir;
    private Button botonE;
    private TextView txtCte,respuesta;
    private int TEXT_REQUEST = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        linkElementos();
        iniciarEelemntos();
        permitirBotones();

        if (savedInstanceState!=null){
            if(savedInstanceState.getBoolean("visible")){
                txtCte.setVisibility(View.VISIBLE);
                respuesta.setVisibility(View.VISIBLE);
            }
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (txtCte.getVisibility() == View.VISIBLE){
            outState.putBoolean("visible",true);
            outState.putString("guarda_respuesta", respuesta.getText().toString());
        }





    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        respuesta.setText(savedInstanceState.getString("guarda_respuesta"));


    }

    private void permitirBotones() {
        botonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent siguiente = new Intent(MainActivity.this,PaginaRespuesta.class);
            siguiente.putExtra("mE",textoAIntroducir.getText().toString());
            startActivityForResult(siguiente,TEXT_REQUEST);

            }
        });
    }


    private void linkElementos() {
        textoAIntroducir = (EditText)findViewById(R.id.mensajeE);
        botonE = (Button)findViewById(R.id.buttonE);
        txtCte = (TextView)findViewById(R.id.mensajeMostrar);
        txtCte.setVisibility(View.INVISIBLE);
        respuesta = (TextView)findViewById(R.id.mensajeR);
        respuesta.setVisibility(View.INVISIBLE);
    }

    private void iniciarEelemntos() {
        textoAIntroducir.setHint(R.string.Hint);
        botonE.setText(R.string.boton_enviar);
        txtCte.setText(R.string.MensajeRecibido);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                respuesta.setVisibility(View.VISIBLE);
                txtCte.setVisibility(View.VISIBLE);
                respuesta.setText(data.getStringExtra("r0"));
            }
        }
    }


}