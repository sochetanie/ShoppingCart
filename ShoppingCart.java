package ShoppingCart;
import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;

public class ShoppingCart {
    static int totalItems;
    static Item [] items;
    static NumberFormat formatter;

    public static void main(String[] args) {
        System.out.println("\n\t\tWelcome to my store!\n");
        totalItems = getNumbersOfItems("How many items do you want to buy? ");
        items = new Item[totalItems];

        int count = 0;
        while (count < totalItems) {
            getItemDetails(count);
            count++;
        }
        displayCart();
    }

    private static void getItemDetails(int index) {
        String name = getItemName("What is the NAME of the item #" +  (index+1) + "? ");
        double price = getItemPrice("What is the PRICE of the item #" + (index+1) + " do you want to buy? ");
        int quantaty = getItemQuantaty("How MANY of item #" + (index+1) + " do you want to buy? ");

        items[index] = new Item(name, quantaty, price);
    }

    private static void displayCart() {
        formatter = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("======================================================");
        System.out.println("Shopping Cart Details: ");
        System.out.println("======================================================");
        for (int i=0; i < totalItems; i++) {
            showLineItem(i);
        }
        System.out.println("======================================================");

        double subtotal = calculateSubTotal();
        double tax = subtotal * 0.0875;
        double total = subtotal + tax;

        System.out.println("Subtotal: " + formatter.format(subtotal));
        System.out.println("NY Sales tax (8.75%): " + formatter.format(tax));
        System.out.println("Total Cost: " + formatter.format(total));
        System.out.println("\n\t\u2661\u2661\u2661 Thank you for shopping with us! \u2661\u2661\u2661");
    }

    private static int getTotalItems() {
        int sum = 0;
        for (int i = 0; i < totalItems; i++) {
            sum += items[i].getQuantaty();
        }
        return sum;
    }

    private static double calculateSubTotal() {
        double total = 0;
        for (int i = 0; i < totalItems; i++) {
            total += items[i].getPrice() * items[i].getQuantaty();
        }
        return total;
    }

    private static void showLineItem(int i) {
        String quantatyText = items[i].getQuantaty() + " peace(s) x ";
        String itemText = items[i].getName() + " -- ";
        String priceText = formatter.format(items[i].getPrice()) + " = " + formatter.format((items[i].getPrice() * items[i].getQuantaty()));

        System.out.println(itemText + quantatyText + priceText);
    }

    private static double getItemPrice(String p) {
        System.out.print(p);
        Scanner scan = new Scanner(System.in);
        return scan.nextDouble();
    }

    private static String getItemName(String n) {
        System.out.print(n);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    private static int getItemQuantaty(String q) {
        System.out.print(q);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    private static int getNumbersOfItems(String q) {
        System.out.print(q);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
}
