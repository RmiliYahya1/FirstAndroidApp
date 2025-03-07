package com.emsi.travaillearendre1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    TextView nom;
    TextView email;
    TextView phone;
    TextView adresse;
    TextView ville;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        nom = findViewById(R.id.nomPrenomText);
        email = findViewById(R.id.emailText);
        phone = findViewById(R.id.phoneText);
        adresse = findViewById(R.id.adresseText);
        ville = findViewById(R.id.villeText);

        String nomPrenom = getIntent().getStringExtra("nom");
        String emailText = getIntent().getStringExtra("mail");
        String phoneText = getIntent().getStringExtra("ph");
        String adresseText = getIntent().getStringExtra("ad");
        String villeText = getIntent().getStringExtra("ville");

        nom.setText("Nom et prénom: " + nomPrenom);
        email.setText("Email: "+emailText);
        phone.setText("Phone: "+phoneText);
        adresse.setText("Adresse: "+adresseText);
        ville.setText("Ville: "+villeText);
    }
}