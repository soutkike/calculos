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


public class CuadraticaFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private  EditText a;
    EditText b;
    EditText c;
    TextView res;
    Button btnres;


    public CuadraticaFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CuadraticaFragment newInstance(String param1, String param2) {
        CuadraticaFragment fragment = new CuadraticaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_cuadratica, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        a=(EditText) getView().findViewById(R.id.a);
        b=(EditText) getView().findViewById(R.id.b);
        c=(EditText) getView().findViewById(R.id.c);
        res=(TextView) getView().findViewById(R.id.resultado);
        btnres= getView().findViewById(R.id.btncalc);
        btnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularCuadratica();
            }
        });
    }

    public void calcularCuadratica(){
        double _a = Double.parseDouble(this.a.getText().toString());
        double _b = Double.parseDouble(this.b.getText().toString());
        double _c = Double.parseDouble(this.c.getText().toString());
        res.setText(MathExpert.calcularCuadratica(_a,_b,_c));
        Bundle bundle = new Bundle();
        bundle.putString("resultado",res.getText().toString());
        Fragment resultadoFragment = new ResultadoFragment();
        resultadoFragment.setArguments(bundle);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragments_layout,resultadoFragment ); // give your fragment container id in first parameter
        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit();
    }
}