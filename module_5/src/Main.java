import fibonacci_methods.Dynamic;
import fibonacci_methods.Iterative;
import fibonacci_methods.Recursion;

public class Main {
    public static void main(String[] args) {

        int n = 10;
        long dynamicResult = Dynamic.dynamicMethod(n);
        long recursionResult = Recursion.recursionMethod(n);
        long iterativeResult = Iterative.iterativeMethod(n);


        System.out.println("Dynamic(" + n + ") = " + dynamicResult);
        System.out.println("Recursion(" + n + ") = " + recursionResult);
        System.out.println("Recursion(" + n + ") = " + iterativeResult);

    }


}
