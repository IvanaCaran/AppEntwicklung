package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // Initialisiere die UI-Elemente
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        // Setze den Click-Listener für den Login-Button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                // Logge die Eingaben
                Log.i("Test Credentials", "Username: " + user + " and Password: " + pass);

                // Hier die Login-Überprüfung durchführen
                if (validateCredentials(user, pass)) {
                    // Login erfolgreich
                    Log.i("Login", "Login erfolgreich");

                    // Zeige eine Bestätigungsmeldung
                    Toast.makeText(Login.this, "Anmeldung erfolgreich", Toast.LENGTH_SHORT).show();

                    // Starte die neue Aktivität (Startseite)
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);

                    // Optional: Schließe die Login-Aktivität
                    finish();
                } else {
                    // Login fehlgeschlagen
                    Log.i("Login", "Login fehlgeschlagen");

                    // Zeige eine Fehlermeldung
                    Toast.makeText(Login.this, "Anmeldung fehlgeschlagen", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateCredentials(String username, String password) {
        // Beispielhafte Überprüfung: Benutzername und Passwort dürfen nicht leer sein
        return !username.isEmpty() && !password.isEmpty();
    }
}
