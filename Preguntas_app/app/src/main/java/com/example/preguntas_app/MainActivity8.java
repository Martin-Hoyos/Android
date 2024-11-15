package com.example.preguntas_app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity8 extends AppCompatActivity {

    RadioButton seneca;
    MediaPlayer mediaPlayer1, mediaPlayer2;
    Handler handler;
    Runnable gameOverRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);


        seneca = findViewById(R.id.Seneca);

        mediaPlayer1 = MediaPlayer.create(this, R.raw.bad);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.up);

        handler = new Handler();
        gameOverRunnable = () -> {
            Toast.makeText(MainActivity8.this, "Game Over: Se acabó el tiempo", Toast.LENGTH_LONG).show();
            finish();
        };
        handler.postDelayed(gameOverRunnable, 30000);
    }

    public void verificar(View v) {
        handler.removeCallbacks(gameOverRunnable);
        if (seneca.isChecked()) {
            mediaPlayer2.start();
            Toast.makeText(this, "Respuesta correcta", Toast.LENGTH_SHORT).show();
            Intent pagina2 = new Intent(this, MainActivity9.class);
            startActivity(pagina2);
        } else {
            mediaPlayer1.start();
            Intent pagina = new Intent(this, Fallo_7.class);
            startActivity(pagina);
        }
    }
}
