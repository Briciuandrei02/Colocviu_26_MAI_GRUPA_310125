package isp.lab4.exercise1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

enum ProductCategory {
    ELECTRONICS("Electronics & Gadgets"),
    FASHION("Fashion"),
    HOME_AND_GARDEN("Home & Garden"),
    BEAUTY("Beauty"),
    TOYS("Toys");

    private String displayName;

    ProductCategory(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}

class Order {
    private String orderId;
    private LocalDateTime date;
    private double totalPrice;
    private List<Product> products = new ArrayList<>();

    public Order(String orderId, LocalDateTime date) {
        this.orderId = orderId;
        this.date = date;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
        this.totalPrice += product.getPrice();
    }
}

class Address {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

class Customer {
    private String customerId;
    private String name;
    private String phone;
    private Address address;

    public Customer(String customerId, String name, String phone, Address address) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
public class Exercise1 {
    public static void main(String[] args) {
// Create some products
        Product tv = new Product("tv001", "Sony TV", 3000, ProductCategory.ELECTRONICS);
        Product phone = new Product("phone001", "iPhone 13", 1500, ProductCategory.ELECTRONICS);
        Product tshirt = new Product("tshirt001", "Tricou Bumbac", 20, ProductCategory.FASHION);
        // Create some customers
        Customer customer1 = new Customer("c001", "Briciu Andrei", "0722233444", new Address("Traian Vuia", "Cluj-Napoca"));
        Customer customer2 = new Customer("c002", "Briciu Mihai", "0722334455", new Address("Doctor C-tin Angelescu", "Craiova"));

        // Create some orders
        Order order1 = new Order("order001", LocalDateTime.now());
        order1.addProduct(tv);
        order1.addProduct(phone);
        order1.setTotalPrice(order1.getTotalPrice() * 0.9); // 10% discount
        order1.setTotalPrice(order1.getTotalPrice() + 10); // taxa livrare
        order1.setTotalPrice(order1.getTotalPrice() * 1.19); // VAT

        Order order2 = new Order("order002", LocalDateTime.now());
        order2.addProduct(tshirt);
        order2.setTotalPrice(order2.getTotalPrice() * 1.19); // VAT

        // Print orders
        System.out.println("Order 1:");
        System.out.println("ID: " + order1.getOrderId());
        System.out.println("Date: " + order1.getDate());
        System.out.println("Pret total: " + order1.getTotalPrice());
        System.out.println("Produse:");
        for (Product product : order1.getProducts()) {
            System.out.println(product.getName() + " - " + product.getProductCategory());
        }
        System.out.println();

        System.out.println("Order 2:");
        System.out.println("ID: " + order2.getOrderId());
        System.out.println("Date: " + order2.getDate());
        System.out.println("Pret total: " + order2.getTotalPrice());
        System.out.println("Produse:");
        for (Product product : order2.getProducts()) {
            System.out.println(product.getName() + " - " + product.getProductCategory());
        }
        System.out.println();

        // Print customers
        System.out.println("Customer 1:");
        System.out.println("ID: " + customer1.getCustomerId());
        System.out.println("Name: " + customer1.getName());
        System.out.println("Phone: " + customer1.getPhone());
        System.out.println("Address: " + customer1.getAddress().getStreet() + ", " + customer1.getAddress().getCity());
        System.out.println();

        System.out.println("Customer 2:");
        System.out.println("ID: " + customer2.getCustomerId());
        System.out.println("Name: " + customer2.getName());
        System.out.println("Phone: " + customer2.getPhone());
        System.out.println("Address: " + customer2.getAddress().getStreet() + ", " + customer2.getAddress().getCity());
        System.out.println();
    }
}