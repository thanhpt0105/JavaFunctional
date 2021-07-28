package optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        String str1 = null;
        String str2 = "Hello";

        System.out.println(Optional.ofNullable(str1).orElse("Default value"));
        System.out.println(Optional.ofNullable(str2).orElse("Default value"));

        Optional.ofNullable("String").ifPresent(System.out::println);
        Optional.ofNullable("String").ifPresentOrElse(s -> System.out.println("not null"), () -> System.out.println("null"));
        Optional.ofNullable(null).ifPresentOrElse(s -> System.out.println("not null"), () -> System.out.println("null"));

    }
}
