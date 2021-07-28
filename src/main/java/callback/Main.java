package callback;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        Consumer<String> callback = firstName -> System.out.println("No last name for " + firstName);
        hello("Tom", "Hank", callback);
        hello("Tom", null, callback);

        hello2("Henry", null, () -> System.out.println("No last name"));
        hello2("Henry", "Cavil", () -> System.out.println("No last name"));
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }
}
