package com.nelkinda.training.tdd;

public enum Fibonacci {
    ;

    public static int fibonacci(int n) {
        switch (n) {
        case 0:
        case 1:
            return n;
        default:
            return fibonacci(n -1) + fibonacci(n - 1);
        }
    }
}
