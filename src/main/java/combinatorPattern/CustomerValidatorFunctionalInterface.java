package combinatorPattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static combinatorPattern.CustomerValidatorFunctionalInterface.*;
import static combinatorPattern.CustomerValidatorFunctionalInterface.ValidationResult.*;

public interface CustomerValidatorFunctionalInterface extends Function<Customer, ValidationResult> {

    static CustomerValidatorFunctionalInterface isEmailValid () {
        return customer -> customer.getEmail().contains("@") ? SUCCESS : EMAIL_NOT_VALID;
    }
    static CustomerValidatorFunctionalInterface isPhoneNumberValid () {
        return customer -> customer.getPhone().contains("+0") ? SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CustomerValidatorFunctionalInterface isAdult () {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() >= 18 ? SUCCESS : NOT_ADULT;
    }

    default CustomerValidatorFunctionalInterface and (CustomerValidatorFunctionalInterface other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return SUCCESS.equals(result) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        NOT_ADULT
    }
}
