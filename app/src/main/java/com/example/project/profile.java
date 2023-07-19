package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class profile extends AppCompatActivity {

    private TextView flightInfoTextView1;
    private TextView flightInfoTextView2;
    private TextView Price;
    private TextView Arr, Dep, Count, Time, Date, Department, Arrival;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        Count = findViewById(R.id.Count);

        Date = findViewById(R.id.Date);
        Department = findViewById(R.id.Department);
        Arrival = findViewById(R.id.Arrival);

        // Получаем данные из Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String selectedDepartment = extras.getString("selectedDepartment");
            String selectedArrival = extras.getString("selectedArrival");
            Integer selectedDate = extras.getInt("selectedDate");
            Integer selectedCount = extras.getInt("selectedCount");


            // Отображаем полученные данные в соответствующих полях
            Department.setText("З " + selectedDepartment+"a");
            Arrival.setText("В " + selectedArrival);

            Date.setText(String.valueOf(selectedDate +".07"));
            Count.setText(String.valueOf("Кількість-" +selectedCount));

            // Ваши действия для отображения информации о полете на полях flightInfoTextView1 и flightInfoTextView2
            // ...
        }
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
