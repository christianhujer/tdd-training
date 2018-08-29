package com.nelkinda.training.tdd;

public enum Factorial {
    ;

    public static int factorial(int number) {
        int factorial = 1;
        for (int i = 2; i < number; i++)
            factorial *= i;
        return factorial;
    }
}
