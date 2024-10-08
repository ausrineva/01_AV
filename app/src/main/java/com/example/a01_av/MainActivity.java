package com.example.a01_av;

import android.graphics.Color;
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

    //Įdėjau masyvą, kurį vėliau panaudoju, kad jis suktųsi kiekvieną kartą paspaudus ant mygtuko.
    private int [] spalvos = {Color.BLUE, Color.GRAY, Color.YELLOW, Color.RED, Color.GREEN, Color.BLACK, Color.WHITE};
    private int dabartinespalva = 0; //pradedame nuo dabartinės spalvos (dėl to nunulinu).

    TextView tekstas;
    Button mygtukas1;
    Button mygtukas2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tekstas = findViewById(R.id.tekstas);
        mygtukas1 = findViewById(R.id.mygtukas1);
        mygtukas2 = findViewById(R.id.mygtukas2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//funkcija, su kuria paspaudus ant mygtuko atsiranda tekstas
        mygtukas1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tekstas.setVisibility(View.VISIBLE);
                mygtukas2.setVisibility(View.VISIBLE);
                mygtukas1.setVisibility(View.GONE);
            }
        });

        mygtukas2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tekstas.setTextColor(spalvos[dabartinespalva]);

                dabartinespalva = (dabartinespalva + 1) % spalvos.length;
            }
        });
    }
}