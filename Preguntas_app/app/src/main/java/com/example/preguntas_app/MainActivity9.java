package com.example.preguntas_app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity9 extends AppCompatActivity {
    MediaPlayer mediaPlayer1, mediaPlayer2, mediaPlayer3;
    RadioButton Trajano;
    Handler handler;
    Runnable gameOverRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        mediaPlayer1 = MediaPlayer.create(this, R.raw.bad);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.up);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.final_real);
        Trajano = findViewById(R.id.Trajano);

        handler = new Handler();
        gameOverRunnable = () -> {
            Toast.makeText(MainActivity9.this, "Game Over: Se acabó el tiempo", Toast.LENGTH_LONG).show();
            finish();
        };
        handler.postDelayed(gameOverRunnable, 30000);
    }


    public void verificar(View view) {

        RadioGroup optionsGroup = findViewById(R.id.group);
        int selectedId = optionsGroup.getCheckedRadioButtonId();
        RadioButton selectedOption = findViewById(selectedId);
        String answer = selectedOption.getText().toString();
        handler.removeCallbacks(gameOverRunnable);

        if (Trajano.isChecked()) {
            mediaPlayer3.start();
            Toast.makeText(this, "Respuesta correcta", Toast.LENGTH_SHORT).show();
            Intent pagina2 = new Intent(this, MainActivity10.class);
            startActivity(pagina2);
        } else {
            mediaPlayer1.start();
            Intent pagina = new Intent(this, Fallo_8.class);
            startActivity(pagina);
        }
    }
}
