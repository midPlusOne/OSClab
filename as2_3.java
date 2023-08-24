/*
Design a class Product with attributes such as name, price, and
category.Implement a class Cart that allows users to add and remove
products, and calculates the total price.Write a program that simulates an
online shopping experience using classes from the shopping package
with exception handling:

*/

package Assignment2;

import java.util.Scanner;

public class as2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the maximum number of products in the cart: ");
        final int maxSize = sc.nextInt();

        Cart cart = new Cart(maxSize);

        try {
            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Add product to cart");
                System.out.println("2. Remove product from cart");
                System.out.println("3. View cart");
                System.out.println("4. Check out");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:

                        if(cart.isCartFull())
                        {
                            System.out.println("The cart is already full. Cannot add more items.");
                            break;
                        }

                        System.out.print("Enter the name of the product: ");
                        String name = sc.next();

                        System.out.print("Enter the price of the product (₹): ");
                        double price = sc.nextDouble();

                        System.out.print("Enter the category of the product: ");
                        String category = sc.next();

                        Product newProduct = new Product(name, price, category);
                        cart.addProduct(newProduct);

                        System.out.println("Product added to cart.");
                        break;

                    case 2:
                        System.out.print("Enter the name of the product to remove: ");
                        String productName = sc.next();

                        if (cart.removeProduct(productName))
                        {
                            System.out.println(productName +" removed from cart.");
                        }
                        else{
                            System.out.println(productName + " Not found");
                        }

                        break;

                    case 3:
                        cart.displayCart();
                        break;

                    case 4:
                        System.out.println("Total price: ₹" + cart.getTotalPrice());
                        System.out.println("Thank you for shopping!");
                       return;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Please enter a valid choice.");
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong! please try again. LOG:  " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}


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
}

class Cart {
    private Product[] items;
    private int itemCount;

    public Cart(int capacity) {
        items = new Product[capacity];
        itemCount = 0;
    }

    public void addProduct(Product product) {
            items[itemCount] = product;
            itemCount++;
    }

    public boolean isCartFull()
    {
        return itemCount >= items.length;
    }

    public boolean removeProduct(String productName) {
        boolean hasRemoved = false;
        for (int i = 0; i < itemCount; i++) {
            if (items[i] != null && items[i].getName().equalsIgnoreCase(productName)) {
                items[i] = null;
                hasRemoved = true;
                break;
            }
        }
        return hasRemoved;
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

        StringBuilder builder = new StringBuilder();


        for (Product product : items) {
            if (product != null) {
                String item = product.getName() + " - ₹" + getTotalPrice() + "\n";
                builder.append(item);
                isEmpty = false;
            }
        }

        if (isEmpty) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("\nItems in cart:");
        System.out.println(builder);
    }
}

