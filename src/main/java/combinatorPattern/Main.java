package combinatorPattern;

import java.time.LocalDate;

import static combinatorPattern.CustomerValidatorFunctionalInterface.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Tom",
                "test@gmail.com",
                "+0123423",
                LocalDate.of(2000, 1,1)
        );

        //traditional way:
        System.out.println(new CustomerValidatorService().isValid(customer));

        //using combination pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);
        System.out.println(result);
    }
}
