package com.example.myapplication;

import android.content.Intent; //Zwischen Aktivitäten navigieren
import android.os.Bundle; //um Speichern des Zustands der Aktivität verwendet wird, wenn diese angehalten und neu gestartet wird.
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;// Vollbilddarstellung
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets; //abstände für ansichten
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Genre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //ruft onCreate Methode der Superklasse auf
        EdgeToEdge.enable(this); //Vollbildschirm
        setContentView(R.layout.activity_genre);

//main Ränder erhält, damit sie nicht von den Systemleisten verdeckt wird
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button b1 = findViewById(R.id.G_button3);
        Button b2 = findViewById(R.id.Genre_button4);
        Button b3 = findViewById(R.id.Genre_button5);
        Button b4 = findViewById(R.id.Genre_button6);
        Button b5 = findViewById(R.id.Genre_button7);
        Button b6 = findViewById(R.id.Genre_button8);
        Button b7 = findViewById(R.id.Genre_button9);
        Button b8 = findViewById(R.id.Genre_button10);
        Button b9 = findViewById(R.id.Genre_button11);
        Button b10 = findViewById(R.id.Genre_button12);

        Button back = (Button)findViewById(R.id.G_button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button)view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button) view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoAntike = new Intent(Genre.this, Genre_Antike.class);
                startActivity(gotoAntike);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button) view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoMittelalter= new Intent(Genre.this, Genre_Mittelalter.class);
                startActivity(gotoMittelalter);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button) view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoRenaissance = new Intent(Genre.this, Genre_Renaissance.class);
                startActivity(gotoRenaissance);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button) view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoBarock = new Intent(Genre.this, Genre_Barock.class);
                startActivity(gotoBarock);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button) view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoRomantik = new Intent(Genre.this, Genre_Romantik.class);
                startActivity(gotoRomantik);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button) view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoImpressionismus = new Intent(Genre.this, Genre_Impressionismus.class);
                startActivity(gotoImpressionismus);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button) view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoExpressionismus = new Intent(Genre.this, Genre_Expressionismus.class);
                startActivity(gotoExpressionismus);
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button) view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoKubismus = new Intent(Genre.this, Genre_Kubismus.class);
                startActivity(gotoKubismus);
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button) view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoPopArt = new Intent(Genre.this, GenrePopArt.class);
                startActivity(gotoPopArt);
            }
        });


    }
}