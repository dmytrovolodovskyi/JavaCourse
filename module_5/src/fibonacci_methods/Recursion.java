package fibonacci_methods;

public class Recursion {

    public static long recursionMethod(int n) {
        if (n <= 1) {
            return n;
        }

        return recursionMethod(n - 1) + recursionMethod(n - 2);
    }
}
