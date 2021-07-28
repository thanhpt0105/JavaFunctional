package combinatorPattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {
    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPhoneNumberValid(String phone) {
        return phone.startsWith("+0");
    }

    private boolean isAdult(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() >= 18;
    }

    public boolean isValid(Customer customer) {
        return isEmailValid(customer.getEmail())
                && isPhoneNumberValid(customer.getPhone())
                && isAdult(customer.getDob());
    }
}
