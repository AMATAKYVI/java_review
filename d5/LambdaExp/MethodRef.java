package d5.LambdaExp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class MethodRef {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(
                List.of("alpha", "beta", "gamma")
        );

        int x = 23;
        int y = 24;
        calculator((a, b) -> a + b, x, y);
    }

    private static <T> void calculator(BinaryOperator<T> function, T x, T y) {
        T result = function.apply(x, y);
        System.out.println("result: " + result);

    }
}
