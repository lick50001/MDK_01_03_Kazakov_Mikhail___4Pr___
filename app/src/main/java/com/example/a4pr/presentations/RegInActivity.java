package com.example.a4pr.presentations;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a4pr.R;

public class RegInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reg_in);

        EditText Email = findViewById(R.id.email);
        EditText Password = findViewById(R.id.et_password);
        EditText Surname = findViewById(R.id.surname);
        EditText Name = findViewById(R.id.name);
        EditText Lastname = findViewById(R.id.lastnamyc);
        Spinner Gender = findViewById(R.id.gendery);

        TextView bthOpenLogIn = findViewById(R.id.bth_open_sign_in);
        bthOpenLogIn.setOnClickListener(v -> {
            finish();
        });

        Button bthLogIn = findViewById(R.id.bth_log_in);

        bthLogIn.setOnClickListener(v -> {
            String email = Email.getText().toString();
            String password = Password.getText().toString();
            String surname = Surname.getText().toString();
            String name = Name.getText().toString();
            String lastname = Lastname.getText().toString();
            //String gender = Gender.getText().toString();

            if (email.isEmpty()) {
                Toast.makeText(this, "Не указана почта пользователя", Toast.LENGTH_SHORT).show();
                return;
            }

            if (password.isEmpty()) {
                Toast.makeText(this, "Не указан пароль пользователя", Toast.LENGTH_SHORT).show();
                return;
            }

            if (surname.isEmpty()) {
                Toast.makeText(this, "Не указана фамилия пользователя", Toast.LENGTH_SHORT).show();
                return;
            }

            if (name.isEmpty()) {
                Toast.makeText(this, "Не указано имя пользователя", Toast.LENGTH_SHORT).show();
                return;
            }

            if (lastname.isEmpty()) {
                Toast.makeText(this, "Не указано отчество пользователя", Toast.LENGTH_SHORT).show();
                return;
            }


        });
    }
}