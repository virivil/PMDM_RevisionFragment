package com.example.vince.pmdm_proyecto;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import static com.example.vince.pmdm_proyecto.PerfilFragment.*;


/**
 */
public class Main2Activity extends Activity implements PerfilFragment.OnFragmentBotonListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);


        // aqui  recojo la info pasada con el intent  desde la act MainActivity,

        Bundle bundlemain = getIntent().getExtras();

        // la asigno a variables
        Integer posicion = bundlemain.getInt("position", 0);

        // Comprobación del paso correcto de los parametros desde actividad Perfil a act Main:

        Toast.makeText(this, "Compruebo que paso correctamente la info  entr Activityes" + posicion , Toast.LENGTH_SHORT).show();



    }

    @Override
    public void onFragmentInteraction(String a, String b) {

    }
}