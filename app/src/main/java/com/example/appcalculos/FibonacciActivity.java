package com.example.appcalculos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FibonacciActivity extends AppCompatActivity {
EditText caja;
TextView tvRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);
        caja = findViewById(R.id.fib);
        tvRes=  findViewById(R.id.resultadofib);
    }


    public void onCalcularFib(View v){
        int a=MathExpert.fibbonacci(Integer.parseInt(caja.getText().toString()));
        tvRes.setText(String.valueOf(a));
    }
}