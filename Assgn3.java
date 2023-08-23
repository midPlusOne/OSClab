/*3 Design a class Product with attributes such as name, price, and
category.Implement a class Cart that allows users to add and remove
products, and calculates the total price.Write a program that simulates an
online shopping experience using classes from the shopping package
with exception handling */
import java.util.Scanner;

class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " - Rs." + price;
    }
}

class Cart {
    private Product[] items;
    private int itemCount;

    public Cart(int capacity) {
        items = new Product[capacity];
        itemCount = 0;
    }

    public void addProduct(Product product) {
        if (itemCount < items.length) {
            items[itemCount] = product;
            itemCount++;
        } else {
            System.out.println("The cart is already full. Cannot add more items.");
        }
    }

    public void removeProduct(String productName) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i] != null && items[i].getName().equalsIgnoreCase(productName)) {
                items[i] = null;
                break;
            }
        }
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : items) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void displayCart() {
        boolean isEmpty = true;
        System.out.println("Items in cart:");
        for (Product product : items) {
            if (product != null) {
                System.out.println(product);
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("Cart is empty.");
        }
    }
}

public class Assgn3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum number of products in the cart: ");
        int capacity = scanner.nextInt();
        Cart cart = new Cart(capacity);

        try {
            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Add product to cart");
                System.out.println("2. Remove product from cart");
                System.out.println("3. View cart");
                System.out.println("4. Check out");
                System.out.println("5. Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter the name of the product: ");
                        scanner.nextLine();
                        String name = scanner.nextLine();

                        System.out.print("Enter the price of the product (Rs.): ");
                        double price = scanner.nextDouble();

                        System.out.print("Enter the category of the product: ");
                        scanner.nextLine();
                        String category = scanner.nextLine();

                        Product productToAdd = new Product(name, price, category);
                        cart.addProduct(productToAdd);
                        System.out.println("Product added to cart.");
                        break;

                    case 2:
                        System.out.print("Enter the name of the product to remove: ");
                        scanner.nextLine();
                        String productName = scanner.nextLine();

                        cart.removeProduct(productName);
                        System.out.println("Product removed from cart.");
                        break;

                    case 3:
                        cart.displayCart();
                        break;

                    case 4:
                        System.out.println("Total price: Rs." + cart.getTotalPrice());
                        System.out.println("Thank you for shopping!");
                        System.exit(0);

                    case 5:
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

