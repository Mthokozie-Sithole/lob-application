import junit.framework.TestCase;
import logic.OrderBook;
import model.Order;
import model.Side;
import org.junit.Test;

public class OrderBookTest extends TestCase {

    @Test
    public void testAddOrder() {
        Order order = new Order(200.00, Side.BUY,5);
        OrderBook orderBook = new OrderBook();

        orderBook.addOrder(order);
        assertEquals(orderBook.getLOB().size(), 1);
        assertNotNull("Order ID generated", order.getId());
    }

    @Test
    public void testDeleteOrder() {
        Order order = new Order(200.00, Side.SELL, 5);
        final String orderId = order.getId();

        Order order2 = new Order(5500.00, Side.BUY, 15);

        OrderBook orderBook = new OrderBook();
        orderBook.addOrder(order);
        orderBook.addOrder(order2);

        assertEquals(orderBook.getLOB().size(), 2);
        orderBook.deleteOrder(orderId);
        assertEquals(orderBook.getLOB().size(), 1);
    }

    @Test
    public void testModifyOrder() {
        Order order = new Order(100000.00, Side.SELL,5);
        final String orderId = order.getId();

        Order order2 = new Order(5500.00, Side.BUY,15);

        OrderBook orderBook = new OrderBook();
        orderBook.addOrder(order);
        orderBook.addOrder(order2);

        orderBook.modifyOrder(orderId, 10);

        assertEquals(order, orderBook.getLOB().peek());
        Order retrievedOrder = orderBook.findOrderById(orderId);
        assertNotNull(retrievedOrder);
        assertEquals(retrievedOrder.getQuantity(), 10);
    }
}
