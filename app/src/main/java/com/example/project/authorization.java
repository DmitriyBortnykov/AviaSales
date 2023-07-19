package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;

public class authorization extends AppCompatActivity {

    private TextInputEditText loginEditText, passwordEditText,NameEditText, SurnameEditText,phoneEditText;
    private Button registerButton;

    // Массивы для хранения данных пользователей
    private ArrayList<String> registeredlogins = new ArrayList<>();
    private ArrayList<String> registeredPhones = new ArrayList<>();
    private ArrayList<String> registeredNames= new ArrayList<>();
    private ArrayList<String> registeredSurnames = new ArrayList<>();

    private ArrayList<String> registeredPasswords = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authorization);

        loginEditText = findViewById(R.id.login);
        passwordEditText = findViewById(R.id.pass);
        phoneEditText = findViewById(R.id.Phone);
        NameEditText = findViewById(R.id.Name);
        SurnameEditText = findViewById(R.id.Surname);
        registerButton=findViewById(R.id.btnReg);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String login = loginEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();
        String name = NameEditText.getText().toString().trim();
        String surname = SurnameEditText.getText().toString().trim();

        if (TextUtils.isEmpty(login) || TextUtils.isEmpty(password) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(name) || TextUtils.isEmpty(surname)) {
            Toast.makeText(this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
            return;
        }

        // Проверка, если логин уже зарегистрирован
        if (registeredlogins.contains(login)) {
            Toast.makeText(this, "Этот логин уже занят, выберите другой", Toast.LENGTH_SHORT).show();
            return;
        }

        // Дополнительные проверки на сложность пароля (например, минимальное количество символов)
        if (password.length() < 6) {
            Toast.makeText(this, "Пароль должен содержать не менее 6 символов", Toast.LENGTH_SHORT).show();
            return;
        }

        // Дополнительные проверки на допустимые символы в логине и пароле
        if (!isValidLogin(login) || !isValidPassword(password)) {
            Toast.makeText(this, "Логин и пароль должны содержать только буквы и цифры без пробелов", Toast.LENGTH_SHORT).show();
            return;
        }

        // Сохранение информации о пользователе в массивах
        registeredlogins.add(login);
        registeredPasswords.add(password);
        registeredPhones.add(phone);
        registeredNames.add(name);
        registeredSurnames.add(surname);

        // Регистрация успешна, перейдите на активность входа
        startActivity(new Intent(authorization.this, com.example.project.login.class));;
        finish();
    }

    private boolean isValidLogin(String login) {
        String regex = "^[a-zA-Z0-9]+$";
        return login.matches(regex);
    }

    private boolean isValidPassword(String password) {
        String regex = "^[a-zA-Z0-9]+$";
        return password.matches(regex);
    }
    public void startMain(View v) {
        Intent main = new Intent(this, com.example.project.MainActivity.class);

        startActivity(main);
    }
    public void startLogin(View v) {
        Intent login = new Intent(this, com.example.project.login.class);
        startActivity(login);
    }

    public void startProfile(View v) {
        Intent prof = new Intent(this, com.example.project.profile.class);
        startActivity(prof);
    }
}
