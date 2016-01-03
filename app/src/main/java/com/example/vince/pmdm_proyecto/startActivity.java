package com.example.vince.pmdm_proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;


import java.util.Timer;
import java.util.TimerTask;


public class startActivity extends Activity {

    private long SPLASH_DELAY = 1000; //1 segundos



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // con esto quitamos el titulo
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_start);




            TimerTask task = new TimerTask() {
                @Override
                public void run() {


                    // Intent para pasar al activuty perfil
                    Intent mainIntent = new Intent(getApplicationContext(),
                            Perfil.class);
                    startActivity(mainIntent);


                    //Destruimos esta activity para prevenir
                    //que el usuario  retorne aqui presionando el boton Atras.
                    finish();
                }

            };

            Timer timer = new Timer();
            timer.schedule(task, SPLASH_DELAY);



    }


}
