package exceptions;

import java.util.HashMap;
import java.util.Map;

class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}

class InvalidCustomerDataException extends RuntimeException {
    public InvalidCustomerDataException(String message) {
        super(message);
    }
}

class Customer {
    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email) {
        if (name == null || name.isBlank()) {
            throw new InvalidCustomerDataException("Customer name cannot be empty.");
        }
        if (email == null || !email.contains("@")) {
            throw new InvalidCustomerDataException("Invalid email format.");
        }
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new InvalidCustomerDataException("Customer name cannot be empty.");
        }
        this.name = name;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new InvalidCustomerDataException("Invalid email format.");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer[ID=" + id + ", Name=" + name + ", Email=" + email + "]";
    }
}

public class CustomerManagementSystem {
    private Map<Integer, Customer> customerRecords = new HashMap<>();

    public void addCustomer(Customer customer) {
        if (customerRecords.containsKey(customer.getId())) {
            throw new InvalidCustomerDataException("Customer ID already exists: " + customer.getId());
        }
        customerRecords.put(customer.getId(), customer);
    }

    public void updateCustomer(int id, String newName, String newEmail) throws CustomerNotFoundException {
        Customer customer = customerRecords.get(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
        }
        customer.setName(newName);
        customer.setEmail(newEmail);
    }

    public void deleteCustomer(int id) throws CustomerNotFoundException {
        Customer removed = customerRecords.remove(id);
        if (removed == null) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
        }
    }

    public static void main(String[] args) {
        CustomerManagementSystem cms = new CustomerManagementSystem();

        try {
            cms.addCustomer(new Customer(1, "Alice", "alice@example.com"));
            cms.addCustomer(new Customer(2, "Bob", "bob@example.com"));
            cms.updateCustomer(1, "Alice Johnson", "alice.j@example.com");
            cms.deleteCustomer(2);
            cms.deleteCustomer(3);

        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (InvalidCustomerDataException e) {
            System.out.println(e.getMessage());
        }
        try {
            cms.addCustomer(new Customer(3, "", "invalidEmail"));
        } catch (InvalidCustomerDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
