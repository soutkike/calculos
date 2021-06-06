package com.example.appcalculos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String calculos[] = {"Ecuaciones Cuadraticas","Fibonacci","Numeros Primos"};
    Spinner opciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opciones= findViewById(R.id.opciones);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,calculos);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        opciones.setAdapter(adapter);
    }

    public void onComenzar(View v){
        Intent intent;
        switch(opciones.getSelectedItemPosition()){
            case 0:
                 intent= new Intent(this,ECuadraticasActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(this,FibonacciActivity.class);
                startActivity(intent);
            case 2:
                intent = new Intent(this,PrimosActivity.class);
                startActivity(intent);

        }

    }


}


