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
import android.widget.TextView;


public class FibonacciFragment extends Fragment {
TextView tv1;
TextView res;
Button calcfib;



    public FibonacciFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FibonacciFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FibonacciFragment newInstance(String param1, String param2) {
        FibonacciFragment fragment = new FibonacciFragment();
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
        return inflater.inflate(R.layout.fragment_fibonacci, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv1 = (TextView) getView().findViewById(R.id.fib);
        res = (TextView) getView().findViewById(R.id.resultadofib);
        calcfib = (Button) getView().findViewById(R.id.calcfib);
        calcfib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularFibonacci();
            }
        });
    }


    public void calcularFibonacci(){
        int n = Integer.parseInt(tv1.getText().toString());
        res.setText(String.valueOf(MathExpert.fibbonacci(n)));
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