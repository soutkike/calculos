package com.example.appcalculos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragments_layout, new CuadraticaFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.opc_cuadratica:
                    selectedFragment= new CuadraticaFragment();
                    break;
                case R.id.opc_fibo:
                    selectedFragment = new FibonacciFragment();
                    break;

                case R.id.opc_primos:
                    selectedFragment = new PrimosFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragments_layout,selectedFragment).commit();
            return true;
        }
    };
}