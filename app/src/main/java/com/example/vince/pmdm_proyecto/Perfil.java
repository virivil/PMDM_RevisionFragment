package com.example.vince.pmdm_proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vince.pmdm_proyecto.PerfilFragment.OnFragmentBotonListener;
import com.example.vince.pmdm_proyecto.R;

public class Perfil extends Activity implements PerfilFragment.OnFragmentBotonListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // quito el titulo
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_perfil);


    }



   @Override
    public void onFragmentInteraction(String A, String B) {


        Log.i("INFO_DAM", "Desde la actividad Perfil" + A + B);

        Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);

      //  meto al intent la info que quiero pasar entre actv. (de Act Perfil a Act Main)
       mainIntent.putExtra("nombre", A); //nombre
       mainIntent.putExtra("edad", B);  //edad

       startActivity(mainIntent);




    }


    ///
}
