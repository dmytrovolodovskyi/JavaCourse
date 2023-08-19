package fibonacci_methods;

import java.util.HashMap;
import java.util.Map;

public class Dynamic {

    private static Map<Integer, Long> value = new HashMap<>();

    public static long dynamicMethod(int n) {
        if (n <= 1) {
            return n;
        }

        if (value.containsKey(n)) {
            return value.get(n);
        }

        long fib = dynamicMethod(n - 1) + dynamicMethod(n - 2);
        value.put(n, fib);
        return fib;
    }
}
