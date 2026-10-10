package data_structures.class_problems;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Customer {
    int id;
    String name;

    Customer(int id, String name) { this.id = id; this.name = name; }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Customer)) return false;
        Customer other = (Customer) obj;
        return id == other.id && name.equals(other.name);
    }

    @Override
    public int hashCode() { return Objects.hash(id, name); }
}

public class CustomerRegistry {
    public static void main(String[] args) {
        Set<Customer> customers = new HashSet<>();
        System.out.println(customers.add(new Customer(101, "Asha")));
        System.out.println(customers.add(new Customer(101, "Asha")));
        customers.add(new Customer(102, "Ravi"));
        System.out.println("Unique count: " + customers.size());
        System.out.println("Contains Asha: " + customers.contains(new Customer(101, "Asha")));
    }
}