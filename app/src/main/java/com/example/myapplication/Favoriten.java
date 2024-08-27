package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


import java.util.Map;


public class Favoriten extends AppCompatActivity {

    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoriten);

        // Initialisiere SharedPreferences
        sharedPreferences = getSharedPreferences("favoriten", Context.MODE_PRIVATE);

        // Setzt den Click-Listener für den "Zurück"-Button
        Button back = findViewById(R.id.favoriten_button1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Setzt den Click-Listener für den "Alle Favoriten löschen"-Button
        Button clearFavoritesButton = findViewById(R.id.clear_favorites_button);
        clearFavoritesButton.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();

            // Nach dem Leeren der Favoriten-SharedPreferences, den Inhalt neu laden
            LinearLayout layout = findViewById(R.id.favoriten_layout);
            displayFavorites(layout);
        });

        // Favoriten anzeigen
        LinearLayout layout = findViewById(R.id.favoriten_layout);
        displayFavorites(layout);
    }

    private void displayFavorites(ViewGroup layout) {
        layout.removeAllViews(); // Sicherstellen, dass das Layout zurückgesetzt wird
        Map<String, ?> allEntries = sharedPreferences.getAll();
        Log.d("Favoriten", "Gespeicherte Schlüssel: " + allEntries.keySet());

        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Integer) {
                int imageResourceId = (int) value;

                // Dynamisch ein ImageView erstellen und hinzufügen
                ImageView imageView = new ImageView(this);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                imageView.setImageResource(imageResourceId);

                layout.addView(imageView);
            } else {
                Log.e("Favoriten", "Gefundener Wert ist kein Integer: " + value);
            }
        }
    }

}



