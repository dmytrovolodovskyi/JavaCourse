package fibonacci_methods;

public class Iterative {

    public static int iterativeMethod(int n) {
        if (n <= 1) {
            return n;
        }

        int fibPrev = 0;
        int fibCurrent = 1;
        for (int i = 2; i <= n; i++) {
            int temp = fibCurrent;
            fibCurrent = fibPrev + fibCurrent;
            fibPrev = temp;
        }

        return fibCurrent;
    }
}
