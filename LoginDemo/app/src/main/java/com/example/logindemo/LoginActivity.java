package com.example.logindemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;

import com.example.logindemo.model.Account;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvUser,tvPass;
    private Button btLogin, btRegister;
    private final static int REQUEST_CODE=10000;
    private Account user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        initView();
        btLogin.setOnClickListener(this);
        btRegister.setOnClickListener(this);
    }

    private void initView() {
        tvUser=findViewById(R.id.txtUsername);
        tvPass=findViewById(R.id.txtPassword);
        btLogin=findViewById(R.id.btnLogin);
        btRegister=findViewById(R.id.btnRegister);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btnLogin) {
            Intent logIntent = new Intent(LoginActivity.this, MainActivity.class);
            Account account = new Account(tvUser.getText().toString(), tvPass.getText().toString());
            logIntent.putExtra("account", account);
            logIntent.putExtra("user",user);
            startActivity(logIntent);
        }
        else if(view.getId()==R.id.btnRegister){
                Intent reIntent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivityForResult(reIntent,REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK){
            if(data==null){
                Toast.makeText(this,"Nguoi dung huy dang ky", Toast.LENGTH_SHORT).show();
            }else{
                user=(Account) data.getSerializableExtra("data");
                tvUser.setText(user.getUsername());
                tvPass.setText(user.getPassword());
            }
        }
    }
}