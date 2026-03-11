package com.example.listviewdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.lview);
        initListView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String selection = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),selection,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initListView() {
        String[] list=getResources().getStringArray(R.array.tech);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.item,list);
        listView.setAdapter(adapter);
    }
}