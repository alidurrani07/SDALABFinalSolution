
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product != null) {
            products.add(product);
            System.out.println(product.getName() + " has been added to your cart.");
        } else {
            System.out.println("Product not found!");
        }
    }

    public void viewCart() {
        System.out.println("Your Shopping Cart:");
        for (Product product : products) {
            System.out.println("- " + product.getName() + " ($" + product.getPrice() + ")");
        }
    }
}
