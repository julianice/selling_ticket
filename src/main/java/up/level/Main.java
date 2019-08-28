package up.level;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        OrderService orderService = new OrderService();
        Collection<Client> clientList = Collections.synchronizedList(new ArrayList<>());
        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Client client = new Client(i, "Name" + i, "LastName" + i);

            Thread thread = new Thread(() -> {
                orderService.increaseOrderCount();
                Integer ticketId = orderService.generateTicketId();
                client.setTicketId(ticketId);
                Gson gson = new Gson();
                String gsonClient = gson.toJson(client);
                System.out.println(Thread.currentThread().getName() + " -> " + gsonClient);

                //maybe use CopyOnWriteArrayList?
                synchronized (clientList) {
                    if (!clientList.contains(client)) {
                        clientList.add(client);
                    }
                }
            });

            thread.start();
            threadList.add(thread);
        }
        for (Thread thread : threadList) {
            thread.join();
        }
        System.out.println(orderService.getOrderCount());
    }
}
