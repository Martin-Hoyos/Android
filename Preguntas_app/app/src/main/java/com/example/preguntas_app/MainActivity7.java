package com.example.preguntas_app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity7 extends AppCompatActivity {
    RadioButton optionCorrect;
    MediaPlayer mediaPlayer1, mediaPlayer2;
    RadioGroup radioGroup;
    Button submitButton;
    Handler handler;
    Runnable gameOverRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);


        RadioGroup radioGroup = findViewById(R.id.radioGroup);
         optionCorrect = findViewById(R.id.optionCorrect);
        Button submitButton = findViewById(R.id.submitButton);
        mediaPlayer1 = MediaPlayer.create(this, R.raw.bad);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.up);

        handler = new Handler();
        gameOverRunnable = () -> {
            Toast.makeText(MainActivity7.this, "Game Over: Se acabó el tiempo", Toast.LENGTH_LONG).show();
            finish();
        };
        handler.postDelayed(gameOverRunnable, 30000);

    }
    public void verificar(View v) {
        handler.removeCallbacks(gameOverRunnable);
        if (optionCorrect.isChecked()) {
            mediaPlayer2.start();
            Toast.makeText(this, "Respuesta correcta", Toast.LENGTH_SHORT).show();
            Intent pagina2 = new Intent(this, MainActivity8.class);
            startActivity(pagina2);
        } else {
            mediaPlayer1.start();
            Intent pagina = new Intent(this, Fallo_6.class);
            startActivity(pagina);
        }
    }
}
