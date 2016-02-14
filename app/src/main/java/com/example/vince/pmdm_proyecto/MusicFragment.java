package com.example.vince.pmdm_proyecto;

import android.app.Fragment;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



/**
 * A placeholder fragment containing a simple view.
 */
public class MusicFragment extends Fragment {

    //Control de volumen
    private int mVolume = 6, mVolumeMax = 10, mVolumeMin = 0;
    //Control sonando
    private int sonando=0; //0=cancion no comenzada; 1=comenzada; 2=pause;

    private SoundPool mSoundPool;
    private int mSoundId;
    private AudioManager mAudioManager;
    private boolean mCanPlayAudio;


    public MusicFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //
        View v = inflater.inflate(R.layout.fragment_music, container, false);


        // Capturamos el servicio que nos proporciona manejar Sonidos
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        // Volumen actual programado
        final TextView tv = (TextView) v.findViewById(R.id.textView1);
        tv.setText(String.valueOf(mVolume));

        // Subir volumen
        final Button upButton = (Button) v.findViewById(R.id.button2);
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Hacer sonar el efecto de click
                mAudioManager.playSoundEffect(AudioManager.FX_KEY_CLICK, mVolume);

                if (mVolume < mVolumeMax) {
                    mVolume += 2;
                    tv.setText(String.valueOf(mVolume));
                }
            }
        });

        // Bajar Volumne
        final Button downButton = (Button) v.findViewById(R.id.button1);
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Hacer sonar el efecto de click
                mAudioManager.playSoundEffect(AudioManager.FX_KEY_CLICK, mVolume);

                if (mVolume > mVolumeMin) {
                    mVolume -= 2;
                    tv.setText(String.valueOf(mVolume));
                }

            }
        });

        // Desactivamos el boton del play
        final Button playButton = (Button) v.findViewById(R.id.button3);
        playButton.setEnabled(false);

        // Creamos el manejador del sonido
        mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        // Cargamos la cancion
        mSoundId = mSoundPool.load(v.getContext(), R.raw.cancion2, 1);

        // Esperamos a que se cargue la cancion completa
        mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                                       int status) {
               // Log.d("AUDIO", "Cargada la cancion");
                if (0 == status) {
                    playButton.setEnabled(true);
                 //   Log.d("AUDIO", "Cargada correctamente");
                }
            }
        });

        // Suena la cancion
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sonando == 0) {
                    playButton.setText("||");
                    sonando = 1;
                    if (mCanPlayAudio)
                        mSoundPool.play(mSoundId, (float) mVolume / mVolumeMax,
                                (float) mVolume / mVolumeMax, 1, 0, 1.0f);
                } else if (sonando == 1) {
                    playButton.setText("Play");
                    sonando = 2;
                    mSoundPool.pause(mSoundId);
                } else {
                    playButton.setText("||");
                    sonando = 1;
                    mSoundPool.resume(mSoundId);
                }
            }

        });

     // Request audio focus
        int result = mAudioManager.requestAudioFocus(afChangeListener,
                AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

        mCanPlayAudio = AudioManager.AUDIOFOCUS_REQUEST_GRANTED == result;







        //

        return v;
    }


    // Get ready to play sound effects
    @Override
    public void onResume() {
       // Log.d("AUDIO", "VOLVIENDO A TOCAR");
        super.onResume();
        mAudioManager.setSpeakerphoneOn(true);
        mAudioManager.loadSoundEffects();
    }

    // Release resources & clean up
    @Override
    public void onPause() {
       // Log.d("AUDIO", "EN PAUSA");
        if (null != mSoundPool) {
            mSoundPool.unload(mSoundId);
            mSoundPool.release();
            mSoundPool = null;
        }
        mAudioManager.setSpeakerphoneOn(false);
        mAudioManager.unloadSoundEffects();
        super.onPause();
    }


    // Listen for Audio focus changes
    AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {

            if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                mAudioManager.abandonAudioFocus(afChangeListener);
                mCanPlayAudio = false;
            }

        }
    };

}
