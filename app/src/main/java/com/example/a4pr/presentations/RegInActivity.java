package com.example.a4pr.presentations;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a4pr.R;
import com.example.a4pr.datas.apis.UserCreate;
import com.example.a4pr.datas.common.CheckInternet;
import com.example.a4pr.domains.callbacks.MyResponseCallback;
import com.example.a4pr.domains.models.User;

public class RegInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_in);

        EditText etEmail = findViewById(R.id.email);
        EditText etPassword = findViewById(R.id.et_password);
        EditText etSurname = findViewById(R.id.surname);
        EditText etName = findViewById(R.id.name);
        EditText etLastname = findViewById(R.id.lastnamyc);
        Spinner spinnerGender = findViewById(R.id.gendery);

        TextView btnOpenLogin = findViewById(R.id.bth_open_sign_in);
        btnOpenLogin.setOnClickListener(v -> finish());

        Button btnRegister = findViewById(R.id.bth_log_in);
        btnRegister.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString();
            String surname = etSurname.getText().toString().trim();
            String name = etName.getText().toString().trim();
            String lastname = etLastname.getText().toString().trim();
            String gender = spinnerGender.getSelectedItem() != null
                    ? spinnerGender.getSelectedItem().toString() : "";

            if (email.isEmpty()) {
                Toast.makeText(this, "Не указана почта", Toast.LENGTH_SHORT).show();
                return;
            }
            if (password.isEmpty()) {
                Toast.makeText(this, "Не указан пароль", Toast.LENGTH_SHORT).show();
                return;
            }
            if (surname.isEmpty() || name.isEmpty() || lastname.isEmpty()) {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
                return;
            }

            registerUser(email, password, surname, name, lastname, gender);
        });
    }

    private void registerUser(String email, String password, String surname,
                              String name, String lastname, String gender) {
        CheckInternet checkInternet = new CheckInternet(this);

        User user = new User();
        user.email = email;
        user.password = password;
        user.surname = surname;
        user.firstname = name;
        user.lastname = lastname;
        user.gender = gender;  // ← ДОБАВЛЕНО

        UserCreate userCreate = new UserCreate(user, checkInternet, new MyResponseCallback() {
            @Override
            public void onCompile(String result) {
                runOnUiThread(() -> {
                    Toast.makeText(RegInActivity.this, "Регистрация успешна!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegInActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                });
            }

            @Override
            public void onError(String error) {
                runOnUiThread(() ->
                        Toast.makeText(RegInActivity.this, "Ошибка: " + error, Toast.LENGTH_LONG).show()
                );
            }
        });

        userCreate.execute();
    }
}