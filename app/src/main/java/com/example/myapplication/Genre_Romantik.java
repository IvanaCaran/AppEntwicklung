package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Genre_Romantik extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.genre_romantik);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button back = (Button)findViewById(R.id.romantik_button1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Initialisieren von SharedPreferences
                sharedPreferences = getSharedPreferences("favoriten", Context.MODE_PRIVATE);

        // Setzt den Click-Listener für die Favoriten-Buttons
        Button favoritenButton1 = findViewById(R.id.button_favorit_17);
        Button favoritenButton2 = findViewById(R.id.button_favorit_18);

        favoritenButton1.setOnClickListener(view -> addImageToFavorites(R.drawable.romantik1));
        favoritenButton2.setOnClickListener(view -> addImageToFavorites(R.drawable.romantik2));
    }

    private void addImageToFavorites(int imageResourceId) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String key = "favorit_" + imageResourceId;
        editor.putInt(key, imageResourceId);
        editor.apply();
    }
}
