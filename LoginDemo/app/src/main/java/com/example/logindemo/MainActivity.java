package com.example.logindemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.logindemo.model.Account;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.txtInfor);
        Intent intent=getIntent();
        if(intent.getSerializableExtra("account")!=null && intent.getSerializableExtra("user")!=null){
            Account log=(Account) intent.getSerializableExtra("account");
            Account user=(Account) intent.getSerializableExtra("user");
            if(log.getUsername().equalsIgnoreCase(user.getUsername()) && log.getPassword().equalsIgnoreCase(user.getPassword())){
                txt.setText("Dang nhap thanh cong!!!");
            }
            else{
                txt.setText("Khong ton tai");
            }
        }
    }
}