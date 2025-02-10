package com.example.reminder_app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar; // Import Toolbar

public class calender extends AppCompatActivity {

    private CalendarView calendarView;
    private EditText editTextReminder;
    private Button btnSave;
    private String selectedDate;
    private SharedPreferences sharedPreferences;
    private Toolbar toolbar; // Declare Toolbar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calender);

        toolbar = findViewById(R.id.toolbar); // Initialize Toolbar
        setSupportActionBar(toolbar); // Set it as the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Show the back button
        getSupportActionBar().setTitle("Calendar"); // Set the title (optional)


        toolbar.setNavigationOnClickListener(v -> onBackPressed()); // Handle back button click


        calendarView = findViewById(R.id.calendarView);
        editTextReminder = findViewById(R.id.editTextReminder);
        btnSave = findViewById(R.id.btnSave);

        sharedPreferences = getSharedPreferences("DiaryEntries", MODE_PRIVATE);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectedDate = year + "-" + (month + 1) + "-" + dayOfMonth;
                loadSavedEntry(selectedDate);
            }
        });

        btnSave.setOnClickListener(v -> saveDiaryEntry());
    }

    private void saveDiaryEntry() {
        if (selectedDate == null) {
            Toast.makeText(this, "Please select a date first!", Toast.LENGTH_SHORT).show();
            return;
        }

        String entryText = editTextReminder.getText().toString();
        if (!entryText.isEmpty()) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(selectedDate, entryText);
            editor.apply();
            Toast.makeText(this, "Diary entry saved!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please write something to save!", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadSavedEntry(String date) {
        String savedEntry = sharedPreferences.getString(date, "");
        editTextReminder.setText(savedEntry);
    }

}