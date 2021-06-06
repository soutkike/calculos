package com.example.appcalculos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PrimosActivity extends AppCompatActivity {
    EditText n;
    TextView res;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primos);
        n=findViewById(R.id.limit);
        res=findViewById(R.id.resultadop);

    }

    public void calcularPrimos(View view){
        String numerosPrimos="";
        Integer respuesta[] = MathExpert.primeNumbers(Integer.valueOf(n.getText().toString()));
        for(Integer integer : respuesta){
            numerosPrimos= numerosPrimos + (""+integer+", ");
        }
        numerosPrimos=numerosPrimos.substring(0,numerosPrimos.length()-2);
        res.setText(numerosPrimos);
    }

}