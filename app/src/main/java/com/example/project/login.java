package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;

public class login extends AppCompatActivity {

    private MaterialEditText loginEditText, passwordEditText;
    private Button loginButton;

    // Массивы для хранения данных пользователей
    private ArrayList<String> registeredlogins = new ArrayList<>();
    private ArrayList<String> registeredPasswords = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // Предполагается, что вы заполняете массивы зарегистрированных пользователей
        // в процессе регистрации в активности RegisterActivity.
        // Здесь вы можете вручную добавить примеры зарегистрированных пользователей.
        registeredlogins.add("login1");
        registeredPasswords.add("password1");
        registeredlogins.add("login2");
        registeredPasswords.add("password2");

        loginEditText = findViewById(R.id.logT);
        passwordEditText = findViewById(R.id.passT);
        loginButton = findViewById(R.id.btnGO);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        String login = loginEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(login) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Пожалуйста, введите логин и пароль", Toast.LENGTH_SHORT).show();
            return;
        }

        // Проверка наличия логина в массиве зарегистрированных пользователей
        int index = registeredlogins.indexOf(login);
        if (index == -1) {
            Toast.makeText(this, "Пользователь не зарегистрирован", Toast.LENGTH_SHORT).show();
            return;
        }

        // Проверка правильности пароля
        String storedPassword = registeredPasswords.get(index);
        if (!password.equals(storedPassword)) {
            Toast.makeText(this, "Неверный пароль", Toast.LENGTH_SHORT).show();
            return;
        }

        // Вход успешен, перейдите на активность профиля или другую активность
        startActivity(new Intent(com.example.project.login.this, MainActivity.class));
        finish();
    }

    public void startAuto(View v) {
        Intent Auto = new Intent(this, com.example.project.authorization.class);
        startActivity(Auto);
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











