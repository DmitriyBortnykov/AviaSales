package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class book extends AppCompatActivity {

    private Spinner departmentSpinner;
    private Spinner arrivalSpinner;
    private Spinner dateSpinner;
    private Spinner CountSpinner;
    private Button filterButton;
    private Button Book;
    private TextView flightInfoTextView1;
    private TextView flightInfoTextView2;
    private TextView Price;
    public double selectedTime = 0.0;
    private Button SelectButton1,SelectButton2;
    private TextView Arr,Dep;
    private String[] dep = {"Київ", "Париж", "Нью-Йорк", "Лондон", "Вільнюс", "Мадрид", "Берлін", "Рим", "Пекін", "Дублін"};
    private String[] arr = {"Київ", "Париж", "Нью-Йорк", "Лондон", "Вільнюс", "Мадрид", "Берлін", "Рим", "Пекін", "Дублін"};
    private Integer[] date = {21, 22, 23, 24, 25};
    private Integer[] Count = {1, 2, 3, 4, 5,6, 7, 8, 9, 10,11, 12, 13, 14, 15};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book);

        Book = findViewById(R.id.Book);

        Price = findViewById(R.id.Price);
        SelectButton1 = findViewById(R.id.btnSel1);
        SelectButton2 = findViewById(R.id.btnSel2);
        departmentSpinner = findViewById(R.id.Department);
        arrivalSpinner = findViewById(R.id.Arrival);
        dateSpinner = findViewById(R.id.Date);
        filterButton = findViewById(R.id.button);
        CountSpinner = findViewById(R.id.Count);
        Arr = findViewById(R.id.OutArr);
        Dep = findViewById(R.id.OutDep);
        flightInfoTextView1 = findViewById(R.id.flight_info_text_view_1);
        flightInfoTextView2 = findViewById(R.id.flight_info_text_view_2);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dep);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        departmentSpinner.setAdapter(adapter);
        arrivalSpinner.setAdapter(adapter);

        ArrayAdapter<Integer> dateAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, date);
        dateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dateSpinner.setAdapter(dateAdapter);
        ArrayAdapter<Integer>CountAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, Count);
        dateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CountSpinner.setAdapter(CountAdapter);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedDepartment = departmentSpinner.getSelectedItem().toString();
                String selectedArrival = arrivalSpinner.getSelectedItem().toString();
                Integer selectedDate = Integer.valueOf((dateSpinner.getSelectedItem().toString()));

                String flightInfo1 = findFlight(selectedDepartment, selectedArrival, selectedDate, 12.00);
                String flightInfo2 = findFlight(selectedDepartment, selectedArrival, selectedDate, 19.00);

                flightInfoTextView1.setText(flightInfo1);
                flightInfoTextView2.setText(flightInfo2);
            }
        });
        Book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                booking();

                // Получаем значения выбранных полей
                String selectedDepartment = departmentSpinner.getSelectedItem().toString();
                String selectedArrival = arrivalSpinner.getSelectedItem().toString();
                Integer selectedDate = Integer.parseInt(dateSpinner.getSelectedItem().toString());
                Integer selectedCount = Integer.parseInt(CountSpinner.getSelectedItem().toString());

                // Создаем Intent для перехода к activity_profile.java
                Intent intent = new Intent(book.this, profile.class);

                                        // Передаем данные через Intent
                intent.putExtra("selectedDepartment", selectedDepartment);
                intent.putExtra("selectedArrival", selectedArrival);
                intent.putExtra("selectedDate", selectedDate);
                intent.putExtra("selectedCount", selectedCount);


                // Запускаем activity_profile
                startActivity(intent);
                                    }
                                });
        SelectButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedDepartment = departmentSpinner.getSelectedItem().toString();
                String selectedArrival = arrivalSpinner.getSelectedItem().toString();
                Arr.setText(selectedArrival);
                Dep.setText(selectedDepartment);
                Price.setText("150$");

                Intent intent = new Intent(book.this, profile.class);
                intent.putExtra("selectedTime", selectedTime);
                double selectedTime = 12.00;
            }
        });
        SelectButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedDepartment = departmentSpinner.getSelectedItem().toString();
                String selectedArrival = arrivalSpinner.getSelectedItem().toString();
                Arr.setText(selectedArrival);
                Dep.setText(selectedDepartment);
                Price.setText("100$");
                double selectedTime = 19.00;
                Intent intent = new Intent(book.this, profile.class);
                intent.putExtra("selectedTime", selectedTime);

            }
        });
    }

    private void booking() {

    }

    public void startMain() {
        Intent main = new Intent(this, com.example.project.MainActivity.class);

        startActivity(main);
    }

    public String findFlight(String department, String arrival, int date, double time) {
        String[][] flights = {
                {"Киев", "Париж", "21.07", "12.00"},
                {"Киев", "Нью-Йорк", "21.07", "19.00"},
                {"Киев", "Париж", "22.07", "12.00"},
                // ... и т.д. Здесь добавьте остальные рейсы
        };

        StringBuilder result = new StringBuilder();

        // Проходим по всем рейсам и ищем совпадения с выбранными параметрами
        for (String[] flight : flights) {
            String depCity = flight[0];
            String arrCity = flight[1];
            double flightDate = Double.parseDouble(flight[2]);
            double flightTime = Double.parseDouble(flight[3]);

            if (depCity.equals(department) && arrCity.equals(arrival) && flightDate == date && flightTime == time) {
                // Формируем строку информации о полете и добавляем ее в результат
                String flightInfo = "В " + time + " из " + depCity + " в " + arrCity + "\n";
                result.append(flightInfo);
            }


            if (result.length() == 0) {
                result.append("Нет рейсов на выбранную дату и время между выбранными городами.");
            }


            if (depCity.equals(department) && arrCity.equals(arrival) && flightDate == (double) date && flightTime == time) {
                // Формируем строку информации о полете и добавляем ее в результат
                String flightInfo = "В " + time + " з " + depCity + " в " + arrCity + "\n";
                result.append(flightInfo);
            }
            return "В " + time + "0" + " з " + department + "a" + " в " + arrival + " на " + date + " число";
        }

        return "В " + time + " з " + department + " в " + arrival + " на " + date + " число";
    }}
