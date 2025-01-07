

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingAssistant {

    private static List<Customer> customers = new ArrayList<>();
    private static List<Product> productList = new ArrayList<>();
    private static List<String> unavailableProducts = new ArrayList<>();
    private static ShoppingCart cart;

    public static void main(String[] args) {
        // Initialize products and unavailable products
        initializeProducts();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Shopping Assistant!");

        // Sign-up phase
        System.out.println("Sign Up:");
        System.out.print("Enter your ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();
        Customer customer = new Customer(customerId, customerName);
        customers.add(customer);
        System.out.println("Sign-up successful!");

        // Login phase
        System.out.println("\nLogin:");
        System.out.print("Enter your ID: ");
        String loginId = scanner.nextLine();
        if (login(customerId)) {
            cart = new ShoppingCart();
            System.out.println("Login successful! Welcome, " + customer.getName() + ".");

            // Shopping phase
            boolean keepShopping = true;
            while (keepShopping) {
                System.out.println("\nOptions:");
                System.out.println("1. Search for an item");
                System.out.println("2. View Cart");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter the item name to search: ");
                        String searchQuery = scanner.nextLine();
                        Product searchedProduct = searchProduct(searchQuery);
                        if (searchedProduct != null) {
                            System.out.print("Do you want to add it to your cart? (yes/no): ");
                            String addToCart = scanner.nextLine();
                            if (addToCart.equalsIgnoreCase("yes")) {
                                cart.addProduct(searchedProduct);
                            }
                        }
                    }
                    case 2 -> cart.viewCart();
                    case 3 -> {
                        keepShopping = false;
                        System.out.println("Thank you for shopping! Goodbye!");
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        } else {
            System.out.println("Login failed. Invalid ID.");
        }

        scanner.close();
    }

    private static boolean login(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return true;
            }
        }
        return false;
    }

    private static Product searchProduct(String name) {
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                if (unavailableProducts.contains(name.toLowerCase())) {
                    System.out.println("Product '" + name + "' is not available.");
                    return null;
                }
                System.out.println("Product found: " + product.getName() + " ($" + product.getPrice() + ")");
                return product;
            }
        }

        if (isElectronicDevice(name)) {
            System.out.println("Product '" + name + "' is not available.");
        } else {
            System.out.println("Product '" + name + "' is not found.");
        }

        return null;
    }

    private static boolean isElectronicDevice(String name) {
        String[] electronicDevices = {"Laptop", "Phone", "Headphones", "Tablet", "Smartwatch", "Camera", "Speaker"};
        for (String device : electronicDevices) {
            if (device.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    private static void initializeProducts() {
        productList.add(new Product("1", "Laptop", 1200.00));
        productList.add(new Product("2", "Phone", 800.00));
        productList.add(new Product("3", "Headphones", 150.00));
        productList.add(new Product("4", "Tablet", 600.00));
        productList.add(new Product("5", "Smartwatch", 200.00));
        productList.add(new Product("6", "Camera", 500.00));
        productList.add(new Product("7", "Speaker", 100.00));

        // Mark some products as unavailable
        unavailableProducts.add("camera");
        unavailableProducts.add("speaker");
    }
}
