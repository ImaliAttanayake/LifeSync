package com.example.reminder_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


import com.example.reminder_app.R;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    Button loginButton;
    CheckBox rememberMe;
    TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        forgotPassword = findViewById(R.id.forgot_password);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailInput = email.getText().toString().trim();
                String passwordInput = password.getText().toString().trim();

                if (emailInput.isEmpty() || passwordInput.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                } else {
                    // Add authentication logic here
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    // Navigate to another activity if needed
                }
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Redirecting to Forgot Password", Toast.LENGTH_SHORT).show();
                // Implement forgot password functionality here
            }
        });
    }
}

