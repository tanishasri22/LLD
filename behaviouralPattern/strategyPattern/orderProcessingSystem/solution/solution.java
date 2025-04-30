package behaviouralPattern.strategyPattern.orderProcessingSystem.solution;

interface DiscountStrategy {
    double applyDiscount(double amount);
}

class SeasonalDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.90;
    }
}

class PromotionalDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount - 20;
    }
}

class ClearanceDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.50;
    }
}

// OrderProcessing (Context) Class
class OrderProcessing {
    private DiscountStrategy discountStrategy;

    // Set the discount strategy at runtime
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    // Apply the discount using the current strategy
    public double processOrder(double amount) {
        if (discountStrategy == null) {
            throw new IllegalStateException("Discount strategy not set.");
        }
        return discountStrategy.applyDiscount(amount);
    }
}

public class solution {
    public static void main(String[] args) {
        OrderProcessing orderProcessing = new OrderProcessing();

        orderProcessing.setDiscountStrategy(new SeasonalDiscount());
        double finalAmount = orderProcessing.processOrder(100);
        System.out.println("Final Amount after Seasonal Discount: " + finalAmount);

        orderProcessing.setDiscountStrategy(new PromotionalDiscount());
        finalAmount = orderProcessing.processOrder(100);
        System.out.println("Final Amount after Promotional Discount: " + finalAmount);

        orderProcessing.setDiscountStrategy(new ClearanceDiscount());
        finalAmount = orderProcessing.processOrder(100);
        System.out.println("Final Amount after Clearance Discount: " + finalAmount);
    }
}

