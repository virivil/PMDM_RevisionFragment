package com.example.vince.pmdm_proyecto;


import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by vince on 3/11/15.
 */

// en esta case estamos extendiendo el adaptador de arreglos  para sobreescribir el metodo getview.
public class MenuAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<elemento> datos;
    private String color;

    public MenuAdapter(Context context, ArrayList<elemento> datos) {
        //super(context, 0, datos);
        this.context=context;
        this.datos=datos;
    }


    // Siguiente metodo , Retorna en el View elaborado e inflado de un elemento en una posición especifica. A este método le debemos pasar un objeto que contenga el string y la imagen?

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int arg0) {
        return datos.get(arg0);
    }

    @Override
    public long getItemId(int position) {
       return datos.get(position).getId();
    }

    public View getView (int position, View convertView, ViewGroup parent){

        LayoutInflater inf= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView==null){

            // para imprimir en la consola.
           // Log.i("INFO_DAM", parent.toString());

            convertView=inf.inflate(R.layout.item_lista,parent,false);
        }

        elemento dir = datos.get(position);
        //RELLENAMOS LA IMAGEN Y EL TEXTO
        ImageView foto = (ImageView) convertView.findViewById(R.id.imageView);
        foto.setImageDrawable(dir.getImagen());
        TextView nombre = (TextView) convertView.findViewById(R.id.textView);
        nombre.setText(dir.getTexto());

        color = dir.getColor();

        convertView.setBackgroundColor(Color.parseColor(color));

        return convertView;
    }

}
