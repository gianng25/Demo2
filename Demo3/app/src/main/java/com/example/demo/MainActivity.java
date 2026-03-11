package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }
    public void email(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, "abc@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
        startActivity(Intent.createChooser(intent,"Chon email.."));
    }
    public void send(View view){
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        startActivity(intent);

    }
}