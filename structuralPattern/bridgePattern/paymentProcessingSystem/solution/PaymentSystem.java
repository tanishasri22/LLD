package structuralPattern.bridgePattern.paymentProcessingSystem.solution;

import java.util.UUID;

interface PaymentGateway {
    void processPayment(double amount, String transactionId);
}

class Stripe implements PaymentGateway {
    public void processPayment(double amount, String transactionId) {
        System.out.println("Processing $" + amount + " via Stripe, Transaction ID: " + transactionId);
    }
}

class PayPalGateway implements PaymentGateway {
    public void processPayment(double amount, String transactionId) {
        System.out.println("Processing $" + amount + " via PayPal, Transaction ID: " + transactionId);
    }
}

class RazorPay implements PaymentGateway {
    public void processPayment(double amount, String transactionId) {
        System.out.println("Processing $" + amount + " via RazorPay, Transaction ID: " + transactionId);
    }
}

abstract class PaymentMethod {
    protected PaymentGateway paymentGateway;

    PaymentMethod(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    abstract void usePaymentMethod(double amount);
}

class CreditCard extends PaymentMethod {
    CreditCard(PaymentGateway paymentGateway) {
        super(paymentGateway);
    }

    public void usePaymentMethod(double amount) {
        String transactionId = UUID.randomUUID().toString();
        System.out.print("Credit Card payment - ");
        paymentGateway.processPayment(amount, transactionId);
    }
}

class DebitCard extends PaymentMethod {
    DebitCard(PaymentGateway paymentGateway) {
        super(paymentGateway);
    }

    public void usePaymentMethod(double amount) {
        String transactionId = UUID.randomUUID().toString();
        System.out.print("\nDebit Card payment - ");
        paymentGateway.processPayment(amount, transactionId);
    }
}

class UPI extends PaymentMethod {
    UPI(PaymentGateway paymentGateway) {
        super(paymentGateway);
    }

    public void usePaymentMethod(double amount) {
        String transactionId = UUID.randomUUID().toString();
        System.out.print("\nUPI payment - ");
        paymentGateway.processPayment(amount, transactionId);
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        // Create payment gateways
        PaymentGateway stripe = new Stripe();
        PaymentGateway paypal = new PayPalGateway();
        PaymentGateway razorpay = new RazorPay();

        // Create payment methods with different gateways
        PaymentMethod creditCard = new CreditCard(stripe);
        PaymentMethod debitCard = new DebitCard(paypal);
        PaymentMethod upi = new UPI(razorpay);

        // Process payments
        creditCard.usePaymentMethod(100.50);
        debitCard.usePaymentMethod(75.25);
        upi.usePaymentMethod(50.00);

        // Demonstrate flexibility - same payment method with different gateway
        PaymentMethod creditCardWithPayPal = new CreditCard(paypal);
        creditCardWithPayPal.usePaymentMethod(200.00);
    }
}
