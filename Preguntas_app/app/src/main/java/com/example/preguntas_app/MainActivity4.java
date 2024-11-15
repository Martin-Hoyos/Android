package com.example.preguntas_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {

    RadioButton sud, india, brasil, china;
    MediaPlayer mediaPlayer1, mediaPlayer2;
    Handler handler;
    Runnable gameOverRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        sud =  findViewById(R.id.sud);
        india= findViewById(R.id.india);
        brasil =  findViewById(R.id.brasil);
        china= findViewById(R.id.china);
        mediaPlayer1 = MediaPlayer.create(this, R.raw.bad);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.up);

        handler = new Handler();
        gameOverRunnable = () -> {
            Toast.makeText(MainActivity4.this, "Game Over: Se acabó el tiempo", Toast.LENGTH_LONG).show();
            finish();
        };
        handler.postDelayed(gameOverRunnable, 30000);
    }

    public void sig (View v){
        handler.removeCallbacks(gameOverRunnable);
        if (sud.isChecked()) {
            mediaPlayer2.start();
            Toast.makeText(this, "Respuesta correcta", Toast.LENGTH_SHORT).show();
            Intent pagina2 = new Intent(this, MainActivity5.class);
            startActivity(pagina2);
        } else {
            mediaPlayer1.start();

            Intent pagina = new Intent(this, Fallo3.class);
            startActivity(pagina);

        }

    }
}