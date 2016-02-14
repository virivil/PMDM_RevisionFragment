package com.example.vince.pmdm_proyecto;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.vince.pmdm_proyecto.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.vince.pmdm_proyecto.R.id.botonguardar;

/**
 * A placeholder fragment containing a simple view.
 */
public class Perfil_2Fragment  extends Fragment implements View.OnClickListener,GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    Button b1;

    // campos de texto :

    EditText edit_text1;
    EditText edit_text2 ;

    private OnFragmentBotonListener mListener;
    SharedPreferences prefs;

    //Fichero de guardado
    private Uri fileUri;

    //Tipos definidos
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;


    public ImageView foto;
    public static File mediaStorageDir;
    public static View v;
    public  static String timeStamp;
    private GoogleApiClient mGoogleApiClient;
    protected static final String TAG="LocalizandoGPS";
    private Location mLastLocation;



    public Perfil_2Fragment() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // creamos archivo para preferencias.
        prefs =  getActivity().getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);




        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .setAccountName("virivil@gmail.com")
                    .build();
        }

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

        v=inflater.inflate(R.layout.fragment_perfil_2, container, false);
        b1=(Button)v.findViewById(botonguardar);
        b1.setOnClickListener(this);


        // instancio campos de texto en la creaciñon,
        edit_text1 = (EditText) v.findViewById(R.id.editText);
        edit_text2 = (EditText) v.findViewById(R.id.editText2);

        // una vez los he instanciado , recuerpo el objeto bundle para poder asignarles el valor que me proporciona el activity perfil 2.



        // Recupero de Preferencias la info.  En caso de que no exista, devolverá el segundo parametro.
        String Nombre = prefs.getString("nombre", "Introduzca su nombre");
        String Apellido = prefs.getString("apellido", "Introduzca su Apellido");

        edit_text1.setText(Nombre);
        edit_text2.setText(Apellido);


        // instanciamos boton de la camara y le asignamos un listener.

        //Lanzamos la cámara
        final Button boton=(Button) v.findViewById(R.id.button);
        final TextView fichero=(TextView) v.findViewById(R.id.textView);
        foto= (ImageView) v.findViewById(R.id.imageView3);
        boton.setOnClickListener(new Button.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         // create Intent to take a picture and return control to the calling application
                                         Intent camara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                                         fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE); // create a file to save the image
                                         camara.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name

                                         // start the image capture Intent
                                         startActivityForResult(camara, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

                                         //Colocamos el nombre del fichero
                                         fichero.setText(fileUri.getPath());



                                     }
                                 }
        );


        // Para localizarnos
        final Button botonL=(Button) v.findViewById(R.id.botonLocalizacion);
        botonL.setOnClickListener(new Button.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {


                                          Toast.makeText(getActivity(), "Compruebo que  tengo los paramentros "+String.valueOf(mLastLocation.getLatitude()), Toast.LENGTH_SHORT).show();


                                      }
                                  }
        );


        return v;
    }




    /** Create a file Uri for saving an image or video */
    private static Uri getOutputMediaFileUri(int type){
        return Uri.fromFile(getOutputMediaFile(type));
    }




    /** Create a File for saving an image or video */
    private static File getOutputMediaFile(int type){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_"+ timeStamp + ".jpg");
        } else if(type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "VID_"+ timeStamp + ".mp4");
        } else {
            return null;
        }



        return mediaFile;
    }


    // al retomar volviendo de la camara
    @Override
    public void onResume()
    {
        super.onResume();
        try
        {
            if(mediaStorageDir.exists()){

                // Leemos el archivo guardado y lo asignamos al ImageView.

                Bitmap myBitmap = BitmapFactory.decodeFile(mediaStorageDir.getAbsolutePath()+File.separator +"IMG_"+ timeStamp + ".jpg");



                ImageView myImage = (ImageView) v.findViewById(R.id.imageView3);

                myImage.setImageBitmap(myBitmap);

            }
        } catch (Exception e){
            Log.d("DAM", "Error iniciando la actividad de nuevo " + e.getMessage());
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;

    }

    public void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    public void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onConnected(Bundle bundle) {

        Toast.makeText(getActivity(), "Conectado con MUUUUUUCHO exito , exito que no falte", Toast.LENGTH_SHORT).show();

        Log.i(TAG,"Conectado con MUUUUUUCHO exito , exito que no falte");
        try {
            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                    mGoogleApiClient);
            if (mLastLocation != null) {
                Log.i(TAG, String.valueOf(mLastLocation.getLatitude()));
                Log.i(TAG, String.valueOf(mLastLocation.getLongitude()));



            }
        }catch (SecurityException e){
            Log.i(TAG,"Denegada la localización");
        }

    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(TAG,"Conexion suspendida o finalizada");
        Toast.makeText(getActivity(), "suspendido", Toast.LENGTH_SHORT).show();



    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.i(TAG,"Error en la conexion : "+connectionResult.getErrorMessage());
        Toast.makeText(getActivity(), "ERROR conectando", Toast.LENGTH_SHORT).show();


    }


    public interface OnFragmentBotonListener {  //ESTE ES EL INTERFAZ QUE EL ACTIVITY SUPOERIOR DEBE IMPLEMENTAR

        void onFragmentInteraction(String a, String b);


    }

    @Override
    public void onClick(View v) {  // ESTE ES EL LISTENER DEL BOTON

        // Almacenar información introducida  ,utilizamos  SharedPreferences.

        // recupero el valor en string de los campos y asigno los valores a dos constantes.
        String N  = edit_text1.getText().toString();
        String A = edit_text2.getText().toString();

        // almaceno la info en sharedpref.
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("nombre", N);
        editor.putString("apellido", A);
        editor.commit();

        // Paso los dos valores
        mListener.onFragmentInteraction(N, A);

    }


}

