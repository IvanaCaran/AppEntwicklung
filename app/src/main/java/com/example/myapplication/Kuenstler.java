package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class Kuenstler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kuenstler);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button b1 = (Button) findViewById(R.id.Kuenstler_button1);
        Button b3 = findViewById(R.id.Kuenstler_button3);
        Button b4 = findViewById(R.id.Kuenstler_button4);
        Button b5 = findViewById(R.id.Kuenstler_button5);
        Button b6 = findViewById(R.id.Kuenstler_button6);
        Button b7 = findViewById(R.id.Kuenstler_button7);
        Button b8 = findViewById(R.id.Kuenstler_button8);
        Button b9 = findViewById(R.id.Kuenstler_button9);
        Button b10 = findViewById(R.id.Kuenstler_button10);
        Button b11 = findViewById(R.id.Kuenstler_button11);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button) view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        Button back = (Button) findViewById(R.id.Kuenstler_button1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button) view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoApelles= new Intent(Kuenstler.this, KuenstlerApellesActivity.class);
                startActivity(gotoApelles);
            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button) view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoGiottoDiBondone = new Intent(Kuenstler.this, KuenstlerGiottoDiBondoneActivity.class);
                startActivity(gotoGiottoDiBondone);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button) view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoLeonardodavinci = new Intent(Kuenstler.this, KuenstlerLeonardoDaVinci.class);
                startActivity(gotoLeonardodavinci);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button) view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoCasparDavidFriedrich = new Intent(Kuenstler.this, KuenstlerCasparDavidFriedrich.class);
                startActivity(gotoCasparDavidFriedrich);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button) view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoClaudeMonet = new Intent(Kuenstler.this, KuenstlerClaudeMonet.class);
                startActivity(gotoClaudeMonet);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button) view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoPierreAugusteRenoir = new Intent(Kuenstler.this, KuenstlerPierreAugusteRenoir.class);
                startActivity(gotoPierreAugusteRenoir);
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button) view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoGustavKlimt = new Intent(Kuenstler.this, KuenstlerGustavKlimt.class);
                startActivity(gotoGustavKlimt);
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button) view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoPabloPicasso = new Intent(Kuenstler.this, KuenstlerPabloPicasso.class);
                startActivity(gotoPabloPicasso);
            }
        });

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button) view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoSalvadorDali = new Intent(Kuenstler.this, KuenstlerSalvadorDali.class);
                startActivity(gotoSalvadorDali);
            }
        });

    }
}
