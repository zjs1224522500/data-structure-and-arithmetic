package tech.shunzi.dynamic.programing;

import java.lang.reflect.InvocationTargetException;

public class Fibonacci {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {


        TestEfficiency.getRunTimeResults(null, Fibonacci.class.getMethod("recursionFib", int.class), 40);


        TestEfficiency.getRunTimeResults(null, Fibonacci.class.getMethod("top2bottomFib", int.class), 40);


        TestEfficiency.getRunTimeResults(null, Fibonacci.class.getMethod("bottom2topFib", int.class), 40);
    }

    public static int recursionFib(int n) {
        if (0 >= n || 1 == n) {
            return n;
        }
        return recursionFib(n - 1) + recursionFib(n - 2);
    }

    public static int top2bottomFib(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] meno = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            meno[i] = -1;
        }
        return top2bottomFibMethod(n, meno);
    }

    private static int top2bottomFibMethod(int n, int[] meno) {
        if (meno[n] != -1) {
            return meno[n];
        }

        if (n <= 2) {
            meno[n] = 1;
        } else {
            meno[n] = top2bottomFibMethod(n - 1, meno) + top2bottomFibMethod(n - 2, meno);
        }
        return meno[n];
    }

    public static int bottom2topFib(int n) {
        if (n <= 1) {
            return n;
        }

        int fib0 = 0;
        int fib1 = 1;
        int fibN = 1;
        for (int i = 2; i <= n; i++) {
            fibN = fib0 + fib1;
            fib0 = fib1;
            fib1 = fibN;
        }
        return fibN;
    }


}
