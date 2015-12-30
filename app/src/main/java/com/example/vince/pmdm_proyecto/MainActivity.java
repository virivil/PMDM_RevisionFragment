package com.example.vince.pmdm_proyecto;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity implements ListFragment.ListFragmentListener,PerfilFragment.OnFragmentBotonListener {

    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // con esto quitamos el titulo
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);


        // aqui  recojo la info pasada con el intent  ,

        Bundle bundleperfil = getIntent().getExtras();

        // la asigno a variables
        String nombre = bundleperfil.getString("nombre");
        String edad = bundleperfil.getString("edad");

        // imprimo por consola
        Log.i("Nombre:", nombre);
        Log.i("Edad:", edad);



    }


    public void onListSelected(int position,String item) {


            Log.i("TRAZA","traza1")  ;

       // Toast.makeText(this, "Posición elegida:" + item, Toast.LENGTH_SHORT).show();

            // Bundle para el paso de info de un fragment a otra.

            Bundle arguments = new Bundle();
            arguments.putString(TextoFragment.ARG_PARAM1 , item);
            arguments.putInt(String.valueOf(TextoFragment.ARG_PARAM2), position);


        if (position == 0) {

            // si la posición es cero , cargamos el Fragment Perfil.

            Log.i("TRAZA","traza2")  ;


            // Intent, pass the Intent's extras to the fragment as arguments
            PerfilFragment secondFragment = new PerfilFragment() ;

            // Add the fragment to the 'fragment_container' FrameLayout
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, secondFragment).commit();



        } else {

            Log.i("TRAZA","traza3")  ;


            // Create a new Fragment to be placed in the activity layout

            TextoFragment firstFragment = new TextoFragment() ;


            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(arguments);

            // Add the fragment to the 'fragment_container' FrameLayout
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, firstFragment).commit();


        }



    }


    @Override
    public void onFragmentInteraction() {
        Log.i("INFO_DAM","por 4 en MainActivity");

    }
}