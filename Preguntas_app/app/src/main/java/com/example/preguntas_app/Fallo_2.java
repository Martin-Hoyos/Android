package com.example.preguntas_app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Fallo_2 extends AppCompatActivity {

    MediaPlayer mediaPlayer1, mediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fallo2);

        mediaPlayer1 = MediaPlayer.create(this, R.raw.segundavida);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.rendirse);

    }

    public void volver(View v){
        Intent pagina = new Intent(this, MainActivity3.class);
        startActivity(pagina);
        mediaPlayer1.start();
    }

    public void burla(View v){
        mediaPlayer2.start();
        Intent pagina = new Intent(this, MainActivity.class);
        startActivity(pagina);
    }
}
