package com.example.logindemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.logindemo.model.Account;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvUser,tvPass;
    private Button btRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        initView();
        btRegister.setOnClickListener(this);
    }
    private void initView() {
        tvUser=findViewById(R.id.txtUsername);
        tvPass=findViewById(R.id.txtPassword);
        btRegister=findViewById(R.id.btnRegister);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btnRegister){
                Account account=new Account(tvUser.getText().toString(),tvPass.getText().toString());
                Intent intent=new Intent();
                intent.putExtra("data",account);
                setResult(RESULT_OK,intent);
                finish();
        }
    }
}