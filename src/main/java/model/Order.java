package model;

import java.util.UUID;

/**
 * Order entity.
 *
 * @author Mthoko
 *
 */
public class Order {
    private final String id;
    private Double price;
    private Side side;
    private int quantity;

    // Static block to generate an ID.
    {
        id = UUID.randomUUID().toString();
    }

    /* Default constructor*/
    public Order() {
    }

    public Order(Double price, Side side, int quantity) {
        this.price = price;
        this.side = side;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", side=" + side +
                ", quantity=" + quantity +
                '}';
    }
}
