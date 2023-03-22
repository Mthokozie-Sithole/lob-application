package logic;

import model.Order;

import java.util.Comparator;

public class OrderComparator implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        return (int) (o2.getPrice() - o1.getPrice());
    }
}
