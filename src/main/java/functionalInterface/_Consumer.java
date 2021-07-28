package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer tom = new Customer("Tom", "29293232");
        greetCustomer(tom);

        //using consumer
        greetCustomerConsumer.accept(tom);

        greetCustomerConsumer2.accept(tom, false);
        greetCustomerConsumer2.accept(tom, true);
    }

    static class Customer{
        private final String name;
        private final String phone;

        Customer(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }

    static void greetCustomer(Customer customer) {
        System.out.println("name: " + customer.name + ", phone: " + customer.phone);
    }

    //Consumer: take 1 input argument and return no results.(void)
    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println("name: " + customer.name + ", phone: " + customer.phone);

    //BiConsumer: take 2 arguments
    static BiConsumer<Customer, Boolean> greetCustomerConsumer2 = (customer, showPhoneNumber) -> System.out.println("name: " + customer.name + ", phone: " + (showPhoneNumber ? customer.phone : "*****"));
}
