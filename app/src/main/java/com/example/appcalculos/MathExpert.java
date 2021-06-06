package com.example.appcalculos;

import java.util.ArrayList;

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

}
