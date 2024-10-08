package com.example.a01_av;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tekstas;
    Button pirmutinismygtukas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tekstas = findViewById(R.id.tekstas);
        pirmutinismygtukas = findViewById(R.id.pirmutinismygtukas);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//funkcija, su kuria paspaudus ant mygtuko atsiranda tekstas
        pirmutinismygtukas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tekstas.setText("Sveiki atvykę!");
            }
        });
 //funkcija su kuria atsidanda antras mygtukas


    }
}