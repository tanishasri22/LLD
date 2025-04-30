package behaviouralPattern.strategyPattern.shippingCostCalculation.solution;

interface ShippingStrategy {
    double calculateShippingCost(Order order);
}

class StandardShippingStrategy implements ShippingStrategy {
    @Override
    public double calculateShippingCost(Order order) {
        System.out.println("Using Standard method");
        return 5.0 + 0.05 * order.getWeight();
    }
}

class ExpressShippingStrategy implements ShippingStrategy {
    @Override
    public double calculateShippingCost(Order order) {
        System.out.println("Using Express method");
        return 10.0 + 0.1 * order.getWeight();
    }
}

class OvernightShippingStrategy implements ShippingStrategy {
    @Override
    public double calculateShippingCost(Order order) {
        System.out.println("Using Overnight method");
        return 20.0 + 0.2 * order.getWeight();
    }
}

class ShippingCostCalculator {
    private ShippingStrategy strategy;

    public ShippingCostCalculator(ShippingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ShippingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculate(Order order) {
        return strategy.calculateShippingCost(order);
    }
}

class Order {
    private double weight;
    private String destination;

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    // constructor, getters, setters
}

class CheckoutPageFactory {
    public ShippingStrategy processOrder(Order order, String shippingMethod) {
        ShippingStrategy strategy;

        switch (shippingMethod.toLowerCase()) {
            case "express":
                strategy = new ExpressShippingStrategy();
                break;
            case "overnight":
                strategy = new OvernightShippingStrategy();
                break;
            case "standard":
            default:
                strategy = new StandardShippingStrategy();
        }

        ShippingCostCalculator calculator = new ShippingCostCalculator(strategy); // context
        double cost = calculator.calculate(order);
        System.out.println("Shipping cost: " + cost);
        return strategy;
    }
}

public class Logistic {
    public static void main(String[] args) {
        Order order = new Order();
        order.setWeight(132.21);
        order.setDestination("delhi");

        CheckoutPageFactory checkoutPage = new CheckoutPageFactory();
        checkoutPage.processOrder(order, "overnight");
        checkoutPage.processOrder(order, "express");
        checkoutPage.processOrder(order, "standard");

    }
}
