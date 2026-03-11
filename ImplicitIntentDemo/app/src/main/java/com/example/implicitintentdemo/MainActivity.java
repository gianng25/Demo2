package com.example.implicitintentdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    private ImageView iWeb, iSms, iPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        iWeb = findViewById(R.id.web);
        iSms = findViewById(R.id.sms);
        iPhone = findViewById(R.id.phone);
        iWeb.setOnClickListener(this);
        iSms.setOnClickListener(this);
        iPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.web){
            Intent w = new Intent(Intent.ACTION_VIEW);
            w.setData(Uri.parse("https://www.youtube.com/"));
            startActivity(w);
        }
        else if(view.getId() == R.id.sms){
            Intent m = new Intent(Intent.ACTION_SENDTO);
            m.setData(Uri.parse("sms:"+"0988997467"));
            m.putExtra("sms_body", "Chào bạn!");
            startActivity(m);
        }
        else if(view.getId() == R.id.phone){
            Intent p = new Intent(Intent.ACTION_DIAL);
            p.setData(Uri.parse("tel:0988997467"));
            startActivity(p);
        }
    }
}
