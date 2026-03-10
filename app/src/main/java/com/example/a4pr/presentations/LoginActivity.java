package com.example.a4pr.presentations;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a4pr.R;
import com.example.a4pr.datas.apis.UserLogin;
import com.example.a4pr.datas.common.CheckInternet;
import com.example.a4pr.domains.callbacks.MyResponseCallback;
import com.example.a4pr.domains.models.User;
import com.google.gson.GsonBuilder;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView btnOpenRegIn = findViewById(R.id.bth_open_reg_in);
        btnOpenRegIn.setOnClickListener(v -> {
            Intent RegIn = new Intent(this, RegInActivity.class);
            startActivity(RegIn);
        });

        Button bthLogIn = findViewById(R.id.bth_log_in);

        bthLogIn.setOnClickListener(v -> {
            TextView etEmail = findViewById(R.id.et_email);
            TextView etPassword = findViewById(R.id.et_password);

            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();

            if (email.isEmpty()) {
                Toast.makeText(this, "Не указана почта пользователя", Toast.LENGTH_SHORT).show();
                return;
            }

            if (password.isEmpty()) {
                Toast.makeText(this, "Не указан пароль пользователя", Toast.LENGTH_SHORT).show();
                return;
            }

            RequestUserLogin(email, password);
        });
    }

    public void RequestUserLogin(String email, String password){
        Context context = this;
        CheckInternet checkInternet = new CheckInternet(this);

        User User = new User();
        User.email = email;
        User.password = password;

        UserLogin RequestUserLogin = new UserLogin(
                User,
                checkInternet,
                new MyResponseCallback() {
                    @Override
                    public void onCompile(String result){
                        Log.d("USER LOGIN", result);
                        Toast.makeText(context, "Успешная авторизация пользователя", Toast.LENGTH_SHORT).show();

                        User AuthUser = new GsonBuilder().create().fromJson(result, User.class);
                    }

                    @Override
                    public void onError(String error){
                        Log.d("USER LOGIN", error);
                        Toast.makeText(context, "При авторизации возникли ошибки", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        RequestUserLogin.execute();
    }
}