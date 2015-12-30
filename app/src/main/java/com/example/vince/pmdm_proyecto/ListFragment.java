package com.example.vince.pmdm_proyecto;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;


public class ListFragment extends Fragment {

    ListFragmentListener mCallback;

    // Container Activity must implement this interface
    public interface ListFragmentListener {
        public void onListSelected(int position, String item);
    }



    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (ListFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }


    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {


        super.onActivityCreated(savedInstanceState);

        //Hacemos un cast
        final ListView listview = (ListView) getActivity().findViewById(R.id.listview);



        // a partir del array de Elemento (clase nueva) creamos una lista de tipo arraylist( lista de arreglos)

        ArrayList<elemento> listaMenu = new ArrayList<elemento>();
        elemento item;

        // Introduzco los datos
        item = new elemento(getResources().getDrawable(R.drawable.ic_account_circle_white_48dp), " Perfil ", "#4b8fb5");
        listaMenu.add(item);
        item = new elemento(getResources().getDrawable(R.drawable.ic_extension_white_48dp), "  Juego ", "#67b8e6");
        listaMenu.add(item);
        item = new elemento(getResources().getDrawable(R.drawable.ic_chrome_reader_mode_white_48dp), "  Instrucciones ", "#457089");
        listaMenu.add(item);
        item = new elemento(getResources().getDrawable(R.drawable.ic_build_white_48dp), "  Info ", "#81d4fa");
        listaMenu.add(item);

        //Utilizamos nuestro Adapter customizado --> Clase  Menuadapter .
        MenuAdapter adapter =  new MenuAdapter(getActivity(),listaMenu);

        //Por último enchufamos el adaptador a la Vista que es el ListView

        // "Conectamos" el adaptador al Listview
        listview.setAdapter(adapter);

        //Sobreescribimos el metodo por defecto del listener de la lista. Lo implementamos más a bajo
        listview.setOnItemClickListener(new MetodoListener());


    }


    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }




    //Implementamos el listener para nuestro listView
    //INNER CLASS
    private class MetodoListener implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            // aquí estaba el PUTO error, esto te devuelve el objeto elemento clicado , no el string del elemento.
            elemento X = (elemento) parent.getItemAtPosition(position);
            //String de la posicion clickada

            String item = X.getTexto();

      // Paso de información
            mCallback.onListSelected(position,item);
        }
    }









}
