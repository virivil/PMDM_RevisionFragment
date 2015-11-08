package com.example.vince.pmdm_proyecto;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


/**
 * Created by vince on 3/11/15.
 */
public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String item = intent.getStringExtra("so");
        Toast.makeText(Main2Activity.this, item, Toast.LENGTH_LONG).show();
    }
}