package com.example.bd_c;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText editTextText,editTextTextPassword ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextText=findViewById(R.id.editTextText);
        editTextTextPassword= findViewById(R.id.editTextTextPassword);
    }

    private void validar(String url){
        StringRequest stringrequest = new StringRequest(Resquest.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                }else {
                    Toast.makeText(this, "¡Empate! No hay más movimientos posibles.", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        }
    }
}