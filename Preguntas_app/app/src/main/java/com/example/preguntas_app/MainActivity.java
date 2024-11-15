package com.example.preguntas_app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    Handler handler;
    Runnable gameOverRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button comenzar =findViewById(R.id.comenzar);
        TextView introdudcion= findViewById(R.id.introdudcion);
        mediaPlayer = MediaPlayer.create(this, R.raw.inicio);

        comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comenzar(v);
            }
        });

        handler = new Handler();
        gameOverRunnable = () -> {
            Toast.makeText(MainActivity.this, "Game Over: Se acabó el tiempo", Toast.LENGTH_LONG).show();
            finish();
        };
        handler.postDelayed(gameOverRunnable, 30000);
    }
    public void comenzar(View v){
        handler.removeCallbacks(gameOverRunnable);
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
        Intent pagina1 = new Intent(this, MainActivity2.class);
        startActivity(pagina1);
    }
}