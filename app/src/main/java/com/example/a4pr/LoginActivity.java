package com.example.a4pr;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;



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

            Toast.makeText(this, "Пользователь авторизован", Toast.LENGTH_SHORT).show();
        });
    }
}