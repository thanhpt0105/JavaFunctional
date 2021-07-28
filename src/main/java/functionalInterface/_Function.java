package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = increment(0);
        System.out.println(increment);


        int x = incrementByOne.apply(1);
        int y = multiplyBy10.apply(x);
        System.out.println(y);
        int z = incrementByOne.andThen(multiplyBy10).apply(1);
        System.out.println(z);

        int biX = incrementBy1ThenMultiplyByX.apply(2, 10);
        System.out.println(biX);

    }
    static int increment(int number) {
        return number + 1;
    }

    //Function interface take 1 argument and return 1 output
    static Function<Integer, Integer> incrementByOne = number -> number + 1;
    static Function<Integer, Integer> multiplyBy10 = number -> number * 10;
    static Function<Integer, Integer> incrementBy1ThenMultiplyBy10 = incrementByOne.andThen(multiplyBy10);

    //BiFunction interface take 2 arguments and return 1 output
    static BiFunction<Integer, Integer, Integer> incrementBy1ThenMultiplyByX = (number, x) -> (number + 1) * x;
}
