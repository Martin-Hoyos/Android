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

public class MainActivity3 extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton correctoButton;
    private Button verificarButton;
    MediaPlayer mediaPlayer1, mediaPlayer2;
    Handler handler;
    Runnable gameOverRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        radioGroup = findViewById(R.id.radioGroup);
        correctoButton = findViewById(R.id.radioButton);
        verificarButton = findViewById(R.id.verificar);
        mediaPlayer1 = MediaPlayer.create(this, R.raw.bad);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.up);

        handler = new Handler();
        gameOverRunnable = () -> {
            Toast.makeText(MainActivity3.this, "Game Over: Se acabó el tiempo", Toast.LENGTH_LONG).show();
            finish();
        };
        handler.postDelayed(gameOverRunnable, 30000);


    }

    public void verificar_2(View v) {
        handler.removeCallbacks(gameOverRunnable);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId == R.id.correcto) {
            Intent intent3 = new Intent(this, MainActivity4.class);
            startActivity(intent3);
            mediaPlayer2.start();
        } else {
            Intent intent2 = new Intent(this, Fallo_2.class);
            startActivity(intent2);
            mediaPlayer1.start();
        }
    }
}