package com.emsi.travaillearendre1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText nomPrenom,email,phone,adresse;
    private Button btn;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        nomPrenom=findViewById(R.id.nomPrenom);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        adresse=findViewById(R.id.adresse);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String ville=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("Marrakech");
        arrayList.add("Fes");
        arrayList.add("Rabat");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom=nomPrenom.getText().toString();
                String mail=email.getText().toString();
                String ph=phone.getText().toString();
                String ad=adresse.getText().toString();
                String ville=spinner.getSelectedItem().toString();
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("nom",nom);
                intent.putExtra("mail",mail);
                intent.putExtra("ph",ph);
                intent.putExtra("ad",ad);
                intent.putExtra("ville",ville);
                startActivity(intent);

            }
        });
    }
}