package com.example.vince.pmdm_proyecto;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vince.pmdm_proyecto.R;

import java.util.ArrayList;


public class TextoFragment extends Fragment {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";





/*    // TODO: Rename and change types of parameters
    private String mParam1;
    private int mParam2;
*/


    // TODO: Rename and change types and number of parameters
    public static TextoFragment newInstance(String param1, String param2) {
        TextoFragment fragment = new TextoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public TextoFragment() {
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

        View v = inflater.inflate(R.layout.fragment_texto, container, false);

        //RECOGEMOS LOS  ARGS

        String so=  getArguments().getString(TextoFragment.ARG_PARAM1);
        int so2=  getArguments().getInt(String.valueOf(TextoFragment.ARG_PARAM2));


        ((TextView) v.findViewById(R.id.textoFragment)).setText("Has accedido a la opción: "+ so+" con el ID: "+so2);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}

