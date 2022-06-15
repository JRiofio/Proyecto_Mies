package com.example.mies_dinapen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CrearCuentas extends AppCompatActivity {


    //...
    Button INFORME;
    //...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuentas);
        setTitle("CREAR CUENTA");

        //...
        INFORME=(Button)findViewById(R.id.btn_ir_informe);
        INFORME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(CrearCuentas.this, com.example.mies_dinapen.Mies_Dinapen.class);
                startActivity(i1);
            }
        });
        //...
    }
}