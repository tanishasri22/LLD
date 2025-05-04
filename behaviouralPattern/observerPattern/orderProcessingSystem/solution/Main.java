package behaviouralPattern.observerPattern.orderProcessingSystem.solution;

import java.util.ArrayList;

class OrderStatusEvent {
    private final String orderId;
    private final String oldStatus;
    private final String newStatus;

    public OrderStatusEvent(String orderId, String oldStatus, String newStatus) {
        this.orderId = orderId;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOldStatus() {
        return oldStatus;
    }

    public String getNewStatus() {
        return newStatus;
    }
}

interface OrderSubject {
    void addObserver(OrderObserver observer);
    void removeObserver(OrderObserver observer);
    void notifyAllObservers(OrderStatusEvent event);
}

interface OrderObserver {
    void onOrderStatusChanged(OrderStatusEvent event);
}

class OrderProcessingService implements OrderSubject {
    private final ArrayList<OrderObserver> observers = new ArrayList<>();
    private String orderId;
    private String status;

    public OrderProcessingService(String orderId) {
        this.orderId = orderId;
        this.status = "pending";
    }

    @Override
    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    public void changeOrderStatus(String newStatus) {
        if (!this.status.equals(newStatus)) {
            OrderStatusEvent event = new OrderStatusEvent(orderId, this.status, newStatus);
            this.status = newStatus;
            notifyAllObservers(event);
        }
    }

    @Override
    public void notifyAllObservers(OrderStatusEvent event) {
        for (OrderObserver observer : observers) {
            observer.onOrderStatusChanged(event);
        }
    }
}


class ShippingService implements OrderObserver {
    @Override
    public void onOrderStatusChanged(OrderStatusEvent event) {
        if ("shipped".equals(event.getNewStatus())) {
            System.out.println("[ShippingService] Preparing shipment for Order ID: " + event.getOrderId());
        }
    }
}

class BillingService implements OrderObserver {
    @Override
    public void onOrderStatusChanged(OrderStatusEvent event) {
        if ("shipped".equals(event.getNewStatus())) {
            System.out.println("[BillingService] Charging customer for Order ID: " + event.getOrderId());
        }
    }
}

class InventoryService implements OrderObserver {
    @Override
    public void onOrderStatusChanged(OrderStatusEvent event) {
        if ("shipped".equals(event.getNewStatus())) {
            System.out.println("[InventoryService] Updating stock for Order ID: " + event.getOrderId());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        OrderProcessingService orderService = new OrderProcessingService("ORD1234");

        // Register observers
        orderService.addObserver(new ShippingService());
        orderService.addObserver(new BillingService());
        orderService.addObserver(new InventoryService());

        System.out.println("---- Status: Pending ----");
        orderService.changeOrderStatus("pending");

        System.out.println("\n---- Status: Shipped ----");
        orderService.changeOrderStatus("shipped");

        System.out.println("\n---- Status: Delivered ----");
        orderService.changeOrderStatus("delivered");
    }
}