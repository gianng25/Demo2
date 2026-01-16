package com.example.demo2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Spinner sp,sp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.test5);
        sp = findViewById(R.id.sp2);
        sp1 = findViewById(R.id.sp1);
        String[] list = {"PTIT","HUST","NEU"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.item,list);
        sp.setAdapter(adapter);
        String[] list1=getResources().getStringArray(R.array.country);
        ArrayAdapter<String> adapter1=new ArrayAdapter<>(this, R.layout.item,list1);
        sp1.setAdapter(adapter1);
    }
}