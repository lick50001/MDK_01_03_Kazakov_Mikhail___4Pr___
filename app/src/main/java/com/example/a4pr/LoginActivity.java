package com.example.a4pr;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView btnOpenSignIn = findViewById(R.id.bth_open_sign_in);
        btnOpenSignIn.setOnClickListener(v -> {
            Intent SignIn = new Intent(this, RegInActivity.class);
            startActivities(SignIn);
        });

        Button bthLogIn = findViewById(R.id.bth_log_in);

        bthLogIn.setOnClickListener(v -> {
            TextView etEmail = findViewById(R.id.et_email);
            TextView etPassword = findViewById(R.id.et_password);

            String email = etEmail.getText().tostring();
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