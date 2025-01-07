# Shopping Assistant Project

This is a simple Java-based Shopping Assistant application that allows customers to sign up, log in, search for items, and add them to their shopping cart. The project was developed using **NetBeans IDE**.

## How to Run the Code

1. **Set up the Environment**
   - Ensure you have **Java SDK** installed on your machine. You can download it from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
   - Install **NetBeans IDE** if you haven't already. You can download it from [here](https://netbeans.apache.org/).

2. **Import the Project into NetBeans**
   - Open NetBeans.
   - Go to `File` -> `Open Project`.
   - Select the directory where the project files are located and click `Open Project`.

3. **Run the Project**
   - Once the project is open, navigate to the `ShoppingAssistant.java` file.
   - Right-click on the file and select `Run File` or simply press `Shift + F6`.

4. **Interacting with the Application**
   - The program will start in the console.
   - You will be prompted to sign up with your ID and name.
   - After signing up, log in by entering your customer ID.
   - Once logged in, you can search for products, add them to your cart, or view your cart.

## Project Overview

### Classes and Their Functions

- **Customer**: Represents a customer with an ID and name.
- **Product**: Represents a product with an ID, name, and price.
- **ShoppingCart**: Manages the products added to the shopping cart. It allows adding products and viewing the cart.
- **ShoppingAssistant**: The main class where the application logic resides. It handles the sign-up, login, shopping, and product management.

### Product Availability

The application includes a list of products (such as Laptop, Phone, Tablet, etc.) and some of them are marked as unavailable (e.g., Camera and Speaker). When searching for a product, the application will notify you if the product is unavailable.

### Features

- **Sign Up**: Allows customers to create a profile.
- **Login**: Customers log in to access their shopping cart.
- **Search Products**: Customers can search for items by name.
- **Add to Cart**: Customers can add found products to their shopping cart.
- **View Cart**: Customers can view the products in their cart.

---

Enjoy shopping with the Shopping Assistant!
