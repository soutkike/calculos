package com.example.appcalculos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class PrimosFragment extends Fragment {
EditText n;
Button calc;
TextView res;

    public PrimosFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static PrimosFragment newInstance(String param1, String param2) {
        PrimosFragment fragment = new PrimosFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_primos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        n = getView().findViewById(R.id.limit);
        calc = getView().findViewById(R.id.calcprim);
        res = getView().findViewById(R.id.resultadop);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPrimos();

            }
        });
    }

    public void calcularPrimos(){
        String numerosPrimos="";
        Integer[] respuesta= MathExpert.primeNumbers(Integer.parseInt(n.getText().toString()));
        for(Integer integer : respuesta){
            numerosPrimos= numerosPrimos + (""+integer+", ");
        }
        numerosPrimos=numerosPrimos.substring(0,numerosPrimos.length()-2);
        res.setText(numerosPrimos);
        Bundle bundle = new Bundle();
        bundle.putString("resultado",numerosPrimos);
        Fragment resultadoFragment = new ResultadoFragment();
        resultadoFragment.setArguments(bundle);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragments_layout,resultadoFragment ); // give your fragment container id in first parameter
        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit();
    }
}