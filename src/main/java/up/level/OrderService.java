package up.level;

import java.util.Random;

public class OrderService {
    int orderCount;

    public int generateTicketId() {
        Random r = new Random();
        Integer ticketId = r.nextInt(50000);
        return ticketId;
    }

    public void increaseOrderCount() {
        orderCount++;
    }

    public Integer getOrderCount() {
        return orderCount;
    }
}

