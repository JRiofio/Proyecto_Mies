package com.example.mies_dinapen.Menus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mies_dinapen.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Menus extends AppCompatActivity {

    FloatingActionButton INFORME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setTitle("Lista De Incidentes");

        INFORME=(FloatingActionButton)findViewById(R.id.btn_agregar_button);
        INFORME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Menus.this, com.example.mies_dinapen.Mies_Dinapen.class);
                startActivity(i1);
            }
        });
        //...
    }

}
