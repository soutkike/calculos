package com.example.appcalculos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Math.pow;

public class ECuadraticasActivity extends AppCompatActivity {
    EditText a;
    EditText b;
    EditText c;
    TextView r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_cuadraticas);
         a = findViewById(R.id.a);
         b = findViewById(R.id.b);
         c = findViewById(R.id.c);
         r = findViewById(R.id.resultado);

    }

    public void calcularCuadratica(View view){
        float x1;
        float x2;
        double a = Double.parseDouble(this.a.getText().toString());
        double b = Double.parseDouble(this.b.getText().toString());
        double c = Double.parseDouble(this.c.getText().toString());
        double d = pow(b, 2) - 4 * a * c;
        if(d >=0){
            if(d==0){
                double x = -b / (2 * a);
                r.setText(String.valueOf(x));
            }else{
                x1 = (float) (-b + Math.sqrt(d) / (2 * a));
                x2 = (float) (-b - Math.sqrt(d) / (2 * a));
                r.setText("x1: "+x1+" x2: "+x2);
            }
        }else{
            double parteReal, parteImaginaria;
            d = Math.abs(d);
            parteReal = -b / (2 * a);
            parteImaginaria = Math.sqrt(d) / (2 * a);
            r.setText("La raíz compleja  es"+parteReal+"  "+parteImaginaria+"i");

        }

    }
}