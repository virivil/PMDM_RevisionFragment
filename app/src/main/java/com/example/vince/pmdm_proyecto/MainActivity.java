package com.example.vince.pmdm_proyecto;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // con esto quitamos el titulo
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);



        //Hacemos un cast
        final ListView listview = (ListView) findViewById(R.id.listview);


        // a partir del array de Elemento (clase nueva) creamos una lista de tipo arraylist( lista de arreglos)

        ArrayList<elemento> listaMenu = new ArrayList<elemento>();
        elemento item;

        // Introduzco los datos
        item = new elemento(getResources().getDrawable(R.drawable.ic_action_name), " Opción 1 ", "Rojo");
        listaMenu.add(item);
        item = new elemento(getResources().getDrawable(R.drawable.ic_action_name), "  Opción 2 ", "Azul");
        listaMenu.add(item);
        item = new elemento(getResources().getDrawable(R.drawable.ic_action_name), "  Opción 3 ", "Morado");
        listaMenu.add(item);
        item = new elemento(getResources().getDrawable(R.drawable.ic_action_name), "  Opción 4 ", "Plata");
        listaMenu.add(item);

        //Utilizamos nuestro Adapter customizado --> Clase  Menuadapter . This = context
        MenuAdapter adapter =  new MenuAdapter(this,listaMenu);

        //Por último enchufamos el adaptador a la Vista que es el ListView

        // "Conectamos" el adaptador al Listview
        listview.setAdapter(adapter);

        //Sobreescribimos el metodo por defecto del listener de la lista. Lo implementamos más a bajo
        listview.setOnItemClickListener(new MetodoListener());
    }


    //Implementamos el listener para nuestro listView
    //INNER CLASS
    private class MetodoListener implements AdapterView.OnItemClickListener{
        public void onItemClick (AdapterView<?> parent, View view, int position, long id){
            //String de la posicion clickada



            String item ;
            item = "Hola";



            Toast.makeText(MainActivity.this,item, Toast.LENGTH_LONG).show();

            //Paso de informacion a otro Intent , es decir , a otra actividad
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            intent.putExtra("so", item);
            startActivity(intent);
        }
    }
}