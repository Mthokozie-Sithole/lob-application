package main;

import logic.OrderBook;
import model.Order;
import model.Side;

import java.util.Iterator;

public class Main {

    static OrderBook orderBook;

    public static void main(String[] args) {
        System.out.println("Adding new order to LOB...");

        // Creating orders to test with.
        Order orderOne = createOrderInstance(200.00, Side.BUY, 5);
        Order orderTwo = createOrderInstance(600.00, Side.BUY, 15);
        Order orderThree = createOrderInstance(700.00, Side.BUY, 25);
        Order orderFour = createOrderInstance(10000.00, Side.BUY, 50);
        Order orderFive = createOrderInstance(700.00, Side.BUY, 50);

        // Adding orders to the LOB
        addOrderToLOB(orderOne);
        addOrderToLOB(orderTwo);
        addOrderToLOB(orderThree);
        addOrderToLOB(orderFour);
        addOrderToLOB(orderFive);

        System.out.println("High priority element: " + getOrderBook().getLOB().peek());
        viewLOBContents();

        // Remove order four from the LOB
        deleteOrder(orderFour.getId());

        // Update order two quantity
       // modifyOrder(orderTwo.getId(), 20);
        viewLOBContents();
    }

    private static Order createOrderInstance(Double price, Side side, int quantity) {
        return new Order(price, side, quantity);
    }

    private static void addOrderToLOB(Order order) {
        OrderBook orderBook = getOrderBook();
        orderBook.addOrder(order);
    }

    private static OrderBook getOrderBook() {
        if (orderBook == null) {
            System.out.println("Initialising order book...");
            orderBook = new OrderBook();
        }
        return orderBook;
    }

    private static void viewLOBContents() {
        Iterator orderBookIterator = getOrderBook().getLOB().iterator();
        System.out.println("LOB contents:");
        while (orderBookIterator.hasNext()) {
            System.out.println(orderBookIterator.next());
        }
    }

    private static void deleteOrder(String orderId) {
        getOrderBook().deleteOrder(orderId);
    }

    private static void modifyOrder(String orderId, int newQuantity) {
        getOrderBook().modifyOrder(orderId, 20);
    }
}