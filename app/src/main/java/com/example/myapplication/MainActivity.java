package com.example.myapplication;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = findViewById(R.id.button1);
        Button b2 = findViewById(R.id.button2);
        Button b3 = findViewById(R.id.mainFavoriten);
        Button b4 = findViewById(R.id.button_quiz);
        searchView = findViewById(R.id.mainSearch);




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button)view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoKuenstler = new Intent(MainActivity.this, Kuenstler.class);
                startActivity(gotoKuenstler);
            }
        });



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button)view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoGenre = new Intent(MainActivity.this, Genre.class);
                startActivity(gotoGenre);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button)view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoFavoriten = new Intent(MainActivity.this, Favoriten.class);
                startActivity(gotoFavoriten);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Das war " + ((Button)view).getText(),
                        Toast.LENGTH_SHORT);
                toast.show();
                Intent gotoQuiz = new Intent(MainActivity.this, QuizNeu.class);
                startActivity(gotoQuiz);
            }
        });

        // Setzt den Listener für die Suchabfrage
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                handleSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    // Methode, um die Suchanfrage zu verarbeiten
    private void handleSearch(String query) {
        // Die gesuchte Eingabe in Kleinbuchstaben umwandeln
        String searchQuery = query.toLowerCase();

        // Intent erstellen, um zur entsprechenden Activity weiterzuleiten
        Intent intent;

        switch (searchQuery) {
            case "salvador dali":
                intent = new Intent(this, KuenstlerSalvadorDali.class);
                break;
            case "claude monet":
                intent = new Intent(this, KuenstlerClaudeMonet.class);
                break;
            case "gustav klimt":
                intent = new Intent(this, KuenstlerGustavKlimt.class);
                break;
            case "giotto di bondone":
                intent = new Intent(this, KuenstlerGiottoDiBondoneActivity.class);
                break;
            case "leonardo da vinci":
                intent = new Intent(this, KuenstlerLeonardoDaVinci.class);
                break;
            case "pablo picasso":
                intent = new Intent(this, KuenstlerPabloPicasso.class);
                break;
            case "pierre auguste renoir":
                intent = new Intent(this, KuenstlerPierreAugusteRenoir.class);
                break;
            case "apelles":
                intent = new Intent(this, KuenstlerApellesActivity.class);
                break;
            case "caspar david friedrich":
                intent = new Intent(this, KuenstlerCasparDavidFriedrich.class);
                break;
            case "romantik":
                intent = new Intent(this, Genre_Romantik.class);
                break;
            case "antike":
                intent = new Intent(this, Genre_Antike.class);
                break;
            case "barock":
                intent = new Intent(this, Genre_Barock.class);
                break;
            case "expressionismus":
                intent = new Intent(this, Genre_Expressionismus.class);
                break;
            case "impressionismus":
                intent = new Intent(this, Genre_Impressionismus.class);
                break;
            case "kubismus":
                intent = new Intent(this, Genre_Kubismus.class);
                break;
            case "mittelalter":
                intent = new Intent(this, Genre_Mittelalter.class);
                break;
            case "renaissance":
                intent = new Intent(this, Genre_Renaissance.class);
                break;
            case "pop art":
                intent = new Intent(this, GenrePopArt.class);
                break;
            default:
                Toast.makeText(this, "Keine Übereinstimmung gefunden", Toast.LENGTH_SHORT).show();
                return;
        }

        startActivity(intent);


    }
}

