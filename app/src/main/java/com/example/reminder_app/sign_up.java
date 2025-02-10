package com.example.reminder_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class sign_up extends AppCompatActivity {

    private EditText etUsername, etFullName, etEmail, etPassword;
    private CheckBox cbAgree;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        // Initialize UI elements
        etUsername = findViewById(R.id.etUsername);
        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignUp = findViewById(R.id.btnSignUp);

        // Handle button click
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String fullName = etFullName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if (username.isEmpty() || fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(sign_up.this, "All fields are required!", Toast.LENGTH_SHORT).show();
                } else if (!cbAgree.isChecked()) {
                    Toast.makeText(sign_up.this, "Please agree to Terms & Conditions", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(sign_up.this, "Sign-Up Successful!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
