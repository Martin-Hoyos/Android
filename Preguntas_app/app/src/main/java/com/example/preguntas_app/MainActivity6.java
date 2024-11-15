package com.example.preguntas_app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity6 extends AppCompatActivity {
    MediaPlayer mediaPlayer1, mediaPlayer2;
    EditText editTextAnswer;
    Handler handler;
    Runnable gameOverRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main6);


        editTextAnswer = findViewById(R.id.editTextAnswer);
        mediaPlayer1 = MediaPlayer.create(this, R.raw.bad);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.up);

        handler = new Handler();
        gameOverRunnable = () -> {
            Toast.makeText(MainActivity6.this, "Game Over: Se acabó el tiempo", Toast.LENGTH_LONG).show();
            finish();
        };
        handler.postDelayed(gameOverRunnable, 30000);

    }

    public void verificar(View v){
        handler.removeCallbacks(gameOverRunnable);
        String answer = editTextAnswer.getText().toString().trim().toLowerCase();
        if (answer.equals("vincent van gogh") || answer.equals("van gogh") || answer.equals("vincent")){
            mediaPlayer2.start();
            Toast.makeText(this, "Respuesta correcta", Toast.LENGTH_SHORT).show();
            Intent pagina2 = new Intent(this, MainActivity7.class);
            startActivity(pagina2);
        } else {
            mediaPlayer1.start();
            Intent pagina = new Intent(this, Fallo_5.class);
            startActivity(pagina);
        }
    }
}