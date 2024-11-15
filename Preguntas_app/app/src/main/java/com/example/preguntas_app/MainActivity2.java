package com.example.preguntas_app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    EditText pearl;
    MediaPlayer mediaPlayer1, mediaPlayer2;
    Handler handler;
    Runnable gameOverRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        pearl = findViewById(R.id.pearl);

        mediaPlayer1 = MediaPlayer.create(this, R.raw.bad);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.up);

        handler = new Handler();
        gameOverRunnable = () -> {
            Toast.makeText(MainActivity2.this, "Game Over: Se acabó el tiempo", Toast.LENGTH_LONG).show();
            finish();
        };
        handler.postDelayed(gameOverRunnable, 30000);
    }

    public void verificar(View v) {
        String resp = pearl.getText().toString();
        String correcto = "pearl harbor";
        handler.removeCallbacks(gameOverRunnable);

        if (resp.toLowerCase().equals(correcto)) {
            mediaPlayer2.start();
            Toast.makeText(this, "Respuesta correcta", Toast.LENGTH_SHORT).show();
            Intent pagina2 = new Intent(this, MainActivity3.class);
            startActivity(pagina2);
        } else {
            mediaPlayer1.start();

            Intent pagina = new Intent(this, Fallo.class);
            startActivity(pagina);
        }
    }
}
