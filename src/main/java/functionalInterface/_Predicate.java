package functionalInterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        String wrongEmail = "aaaaaa@gmail";
        System.out.println(isEmailValid(wrongEmail));
        String correctEmail = "aaaaaa@gmail.com";
        System.out.println(isEmailValid(correctEmail));

        //using Predicate
        System.out.println(isEmailValidPredicate.test(correctEmail));

        boolean test = isEmailValidPredicate.and(isStringContainGmail).test(correctEmail);
        System.out.println(test);
        //can be used with and/or as boolean
//        isEmailValidPredicate.or(String::isEmpty);
    }

    static boolean isEmailValid (String email) {
        return email.contains("@") && email.contains(".");
    }

    //Predicate represent predicate of 1 argument.
    static Predicate<String> isEmailValidPredicate = email -> email.contains("@") && email.contains(".");

    static Predicate<String> isStringContainGmail = email -> email.toLowerCase().contains("gmail");
}
