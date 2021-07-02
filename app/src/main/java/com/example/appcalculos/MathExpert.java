package com.example.appcalculos;

import android.view.View;

import java.util.ArrayList;

import static java.lang.Math.pow;

public class MathExpert {


    public static int fibbonacci(int n){
        if (n == 0){
            return 0;
        } else if (n == 1){
            return 1;
        }else{
            return fibbonacci(n-1) + fibbonacci(n-2);
        }

    }

    public static Integer[] primeNumbers(int n){
        ArrayList<Integer> misNumeros = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)){
                misNumeros.add(i);
            }
        }
        Integer[] numerosPrimos = new Integer[misNumeros.size()];
        numerosPrimos = misNumeros.toArray(numerosPrimos);
        return numerosPrimos;
    }

    public static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    public static String calcularCuadratica(double a, double b, double c){
        float x1;
        float x2;
        double d = pow(b, 2) - 4 * a * c;
        if(d >=0){
            if(d==0){
                double x = -b / (2 * a);
               return "x: "+x;
            }else{
                x1 = (float) (-b + Math.sqrt(d) / (2 * a));
                x2 = (float) (-b - Math.sqrt(d) / (2 * a));
                return("x1: "+x1+" x2: "+x2);
            }
        }else{
            double parteReal, parteImaginaria;
            d = Math.abs(d);
            parteReal = -b / (2 * a);
            parteImaginaria = Math.sqrt(d) / (2 * a);
            return("La raíz compleja  es"+parteReal+"  "+parteImaginaria+"i");

        }

    }

}
