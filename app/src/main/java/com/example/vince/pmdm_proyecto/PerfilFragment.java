package com.example.vince.pmdm_proyecto;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vince.pmdm_proyecto.R;

import javax.security.auth.callback.Callback;

import static com.example.vince.pmdm_proyecto.R.id.botonjugar;
import static com.example.vince.pmdm_proyecto.R.id.editText;
import static com.example.vince.pmdm_proyecto.R.id.editText2;
import static com.example.vince.pmdm_proyecto.R.id.textView2;
import static com.example.vince.pmdm_proyecto.R.id.textView3;

/**
 * A placeholder fragment containing a simple view.
 */

public class PerfilFragment extends Fragment implements View.OnClickListener {

    Button b1;

    // campos de texto :

    EditText edit_text1;

    EditText edit_text2 ;

    private OnFragmentBotonListener mListener;


    public PerfilFragment() {
        // Required empty public constructor

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

 @Override
 public void onAttach(Activity activity) {
     super.onAttach(activity);
     try {
         mListener = (OnFragmentBotonListener) activity;
     } catch (ClassCastException e) {
         throw new ClassCastException(activity.toString()
                 + " must implement OnFragmentInteractionListener");
     }
 }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_perfil, container, false);
        b1=(Button)v.findViewById(botonjugar);

        b1.setOnClickListener(this);  // añadido despues del email de paco.


        // recupero la info rellenada en los campos, antes he declarado los campos , ahora los instancia
        edit_text1 = (EditText) v.findViewById(R.id.editText);

        edit_text2 = (EditText) v.findViewById(R.id.editText2);


        return v;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;

    }


/**
    /**
     * ESTE ES EL INTERFAZ QUE EL ACTIVITY SUPOERIOR DEBE IMPLEMENTAR
     */
    public interface OnFragmentBotonListener {

        public void onFragmentInteraction(String a, String b);


    }
    /**
     * ESTE ES EL LISTENER DEL BOTON
     *
     */
    @Override
    public void onClick(View v) {

        //Llamamos al callback

        Log.i("INFO_DAM", "por 2 en PerfilFragment");



        // recupero el valor en string de los campos y asigno los valores a dos constantes.

        String Name = edit_text1.getText().toString();
        String Years = edit_text2.getText().toString();

        // Paso los dos valores

        mListener.onFragmentInteraction(Name, Years);



    }


}

