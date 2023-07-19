package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.slice.SliceItem;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.graphics.Color;

import android.view.MotionEvent;

import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
Button btnBook,btnFiltr,BtnOpen,BtnLogin;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnOpen = findViewById(R.id.btnbook);


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
    public void startLog(View v) {
        //Перевірка даних,розблокування бронювання
        //Перевірка даних,розблокування бронювання
        //Перевірка даних,розблокування бронювання
        Intent log = new Intent(this, com.example.project.login.class);
        startActivity(log);//Перевірка даних,розблокування бронювання
    }
    public void booking(View v) {
        Intent book = new Intent(this, com.example.project.book.class);
        startActivity(book);
    }//Виклик вікна в три стадії,перша фільтр по даті та місцю,друга показ доступних рейсів,третя-бронювання з вибором кільккості
}