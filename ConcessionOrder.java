package ticketbooking;


import java.util.*;

public class ConcessionOrder {
    private int orderId;
    private Customer customer;
    private HashMap<String, Integer> items;
    private double totalAmount;

    public ConcessionOrder(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new HashMap<>();
        this.totalAmount = 0;
    }

    public void addItem(String item, int qty, double price) {
        items.put(item, items.getOrDefault(item, 0) + qty);
        totalAmount += qty * price;
    }

    public void generateReceipt() {
        System.out.println("\n=== CONCESSION RECEIPT ===");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey() + " x" + entry.getValue());
        }
        System.out.println("Total: ₹" + totalAmount);
        System.out.println("==========================\n");
    }
}
