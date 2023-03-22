package logic;

import model.Order;

import java.util.*;

public class OrderBook {
    private static PriorityQueue<Order> LOB = null;

    /**
     * Default constructor.
     * */
    public OrderBook() {
        LOB = new PriorityQueue<>(new OrderComparator());
    }

    /**
     * Adds a new order to the LOB.
     *
     * @param @{@code Order} - the new order to be added to the LOB.
     * */
    public synchronized void addOrder(Order order) {
       LOB.add(order);
    }

    /**
     * Deletes an order from the LOB.
     *
     * @param orderId - the ID uniquely identifying an order to be deleted.
     *
     * */
    public boolean deleteOrder(String orderId) {
        System.out.println("Deleting order by ID: " + orderId + "...");
        Order order = this.findOrderById(orderId);
        return LOB.remove(order);
    }

    /**
     * Modifies the quantity of an order.
     *
     * @param orderId - the ID uniquely identifying an order to be modified.
     * @param newQuantity - the new quantity to update the order with.
     *
     * */
    public void modifyOrder(final String orderId, final int newQuantity) {
        Order orderToUpdate = this.findOrderById(orderId);
        this.updateOrder(orderToUpdate,  newQuantity);
    }

    private void updateOrder(Order orderToUpdate, int newQuantity) {
        System.out.println("Updating order: " + orderToUpdate);

        // Remove order with the old quantity
        System.out.println("Removing the order with the old quantity...");
        System.out.println("Order removed successfully: " + this.deleteOrder(orderToUpdate.getId()));

        // Set new quantity
        System.out.println("Updating order with new quantity...");
        orderToUpdate.setQuantity(newQuantity);

        // Change priority (Add modified order at the end of the queue)
        LOB.add(orderToUpdate);

    }

    /**
     * Returns the LOB.
     *
     * @return @{@code Queue}
     *
     * */
    public Queue<Order> getLOB() {
        return LOB;
    }

    /**
     * Retrieves an order from the LOB using the provided order ID.
     *
     * @param orderId - the order ID to retrieve an order by.
     *
     * @return @{@code Order}
     *
     * */
    public Order findOrderById(String orderId) {
        return LOB.stream().filter(order -> order.getId().equals(orderId))
                .findFirst().orElse(null);
    }


}
