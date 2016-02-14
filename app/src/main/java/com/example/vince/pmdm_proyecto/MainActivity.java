package com.example.vince.pmdm_proyecto;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;

import android.widget.Toast;



public class MainActivity extends Activity implements ListFragment.ListFragmentListener,PerfilFragment.OnFragmentBotonListener,Perfil_2Fragment.OnFragmentBotonListener {

    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // con esto quitamos el titulo
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        //Checkamos si estamos en un dispositivo grande o no

        if (findViewById(R.id.fragment_container) != null) {
            // si es tablet

            // aqui  recojo la info pasada con el intent  desde la act Perfil,

            Bundle bundleperfil = getIntent().getExtras();

            // la asigno a variables
            String nombre = bundleperfil.getString("nombre");
            String edad = bundleperfil.getString("edad");

            // Comprobación del paso correcto de los parametros desde actividad Perfil a act Main:

            Toast.makeText(this, "Compruebo que paso correctamente la info  entr Activityes" + nombre + edad, Toast.LENGTH_SHORT).show();
        }

    }


    public void onListSelected(int position,String item) {




        // Bundle para el paso de info de esta actividad a un fragment

        Bundle arguments = new Bundle();
        arguments.putString(TextoFragment.ARG_PARAM1 , item);
        arguments.putInt(String.valueOf(TextoFragment.ARG_PARAM2), position);

        if (findViewById(R.id.fragment_container) != null) {              // si es tableta


                        if (position == 0) {                              // si la posición es cero , cargamos el Fragment Perfil.


        /*                    // Intent, pass the Intent's extras to the fragment as arguments
                            PerfilFragment secondFragment = new PerfilFragment();

                            // Add the fragment to the 'fragment_container' FrameLayout
                            getFragmentManager().beginTransaction().replace(R.id.fragment_container, secondFragment).commit();
    */

                            // Intent, pass the Intent's extras to the fragment as arguments
                            Perfil_2Fragment secondFragment = new Perfil_2Fragment();

                            // Add the fragment to the 'fragment_container' FrameLayout
                            getFragmentManager().beginTransaction().replace(R.id.fragment_container, secondFragment).commit();



                        }else if (position == 1) {                  // si la posición es uno , cargamos el Fragment Music.


                            // Intent, pass the Intent's extras to the fragment as arguments
                            MusicFragment secondFragment = new MusicFragment();

                            // Add the fragment to the 'fragment_container' FrameLayout
                            getFragmentManager().beginTransaction().replace(R.id.fragment_container, secondFragment).commit();

                        } else {



                            // Create a new Fragment to be placed in the activity layout

                            TextoFragment firstFragment = new TextoFragment() ;


                            // In case this activity was started with special instructions from an
                            // Intent, pass the Intent's extras to the fragment as arguments
                            firstFragment.setArguments(arguments);

                            // Add the fragment to the 'fragment_container' FrameLayout
                            getFragmentManager().beginTransaction().replace(R.id.fragment_container, firstFragment).commit();

                        }
        } else {              // si es movil



                        if (position == 0) {                           //  meto al intent la info que quiero pasar entre esta actv y la que quiero lanzar.

/*
                            Intent mainIntent = new Intent(getApplicationContext(), Main2Activity.class);
                            mainIntent.putExtra("posicion", position); //posicion clickada , intent para pasar la info al main activity 2
                            startActivity(mainIntent);
*/
                            Intent mainIntent = new Intent(getApplicationContext(), Perfil_2.class);
                            mainIntent.putExtra("posicion", position); //posicion clickada , intent para pasar la info al main activity 2
                            startActivity(mainIntent);


                        } else if (position == 1) {

                            Intent mainIntent = new Intent(getApplicationContext(), MusicActivity.class);
                            mainIntent.putExtra("posicion", position); //posicion clickada , intent para pasar la info a la activity Music
                            startActivity(mainIntent);

                        } else {


                        }



        }




    }


    @Override
    public void onFragmentInteraction(String A, String B) {

        // Comprobación del paso correcto de los parametros desde actividad Perfil a act Main:

        Toast.makeText(this,"Compruebo que paso correctamente la info del Fragment a la Act Main " + A + B , Toast.LENGTH_SHORT).show();
    }
}