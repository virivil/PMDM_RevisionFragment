package com.example.vince.pmdm_proyecto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

/**
 * Created by vince on 5/2/16.
 */
public class Perfil_2 extends Activity  implements Perfil_2Fragment.OnFragmentBotonListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // quito el titulo
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_perfil_2);


    }


    @Override
    public void onFragmentInteraction(String A, String B) {    // aquí recibo la info desde el Fragment perfil 2.  Aquí puedo almacenar esa info.



        Toast.makeText(this, "Compruebo que paso correctamente la info del Fragment Perfil 2 a la Act Perfil 2 " + A +" " +B, Toast.LENGTH_SHORT).show();


        Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);

        //  meto al intent la info que quiero pasar entre actv. (de Act Perfil a Act Main)
        mainIntent.putExtra("nombre", A); //nombre
        mainIntent.putExtra("apellido", B);  //edad

        startActivity(mainIntent);

    }
}
