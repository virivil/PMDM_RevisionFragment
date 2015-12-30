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

/**
   EditText edit_text1;

    EditText edit_text2 ;

    //  INSTANCIAMOS el boton para asignarle  un listener.
    Button b;
**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // quito el titulo
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_perfil);




            // INSTANCIAMOS el boton para asignarle  un listener.
            //Button b = (Button) findViewById(R.id.botonjugar);







        /**        b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Log.i("INFO_DAM","por 1 en Perfil");

                        // recupero la info rellenada

                        // antes he declarado los campos , ahora los instancia
                        edit_text1 = (EditText) findViewById(R.id.editText);

                        edit_text2 = (EditText) findViewById(R.id.editText2);

                        // recupero el valor en string de los campos

                        String Name = edit_text1.getText().toString();
                        String Years = edit_text2.getText().toString();



                        //  Intent para pasar al mainactivity
                        Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);


                        //  meto al intent la info que quiero pasar entre actv.
                        mainIntent.putExtra("nombre", Name); //nombre
                        mainIntent.putExtra("edad", Years);  //edad

                        // inicio la otra actv.
                        startActivity(mainIntent);

                    }
                }); **/


    }

/**
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_perfil, menu);
        return true;
    }

**/

/**    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    } **/





   @Override
    public void onFragmentInteraction() {


        Log.i("INFO_DAM", "Pruebaaaaaa");

        Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
       startActivity(mainIntent);




    }


    ///
}
