package functionalInterface;

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

    }
    static int increment(int number) {
        return number + 1;
    }

    static Function<Integer, Integer> incrementByOne = number -> number + 1;
    static Function<Integer, Integer> multiplyBy10 = number -> number * 10;
    static Function<Integer, Integer> incrementBy1ThenMultiplyBy10 = incrementByOne.andThen(multiplyBy10);
}
