package creationalPattern.factory.factoryMethod.parameterisedFactorymethod.solutions;

import java.util.Map;
import java.util.HashMap;

// Step 1: Payment Interface
interface Payment {
    void processPayment(double amount);
}

// Step 2: Concrete Payment Implementations
class CreditCardPayment implements Payment {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of ₹" + amount + " using card number: " + cardNumber);
    }
}

class DebitCardPayment implements Payment {
    private String cardNumber;

    public DebitCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void processPayment(double amount) {
        System.out.println("Processing debit card payment of ₹" + amount + " using card number: " + cardNumber);
    }
}

class UPIPayment implements Payment {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    public void processPayment(double amount) {
        System.out.println("Processing UPI payment of ₹" + amount + " using UPI ID: " + upiId);
    }
}

// Step 3: PaymentFactory Interface
abstract class PaymentFactory {
    public abstract Payment createPaymentMethod(Map<String, String> params);
}

// Step 4: Concrete Factories
class CreditCardFactory extends PaymentFactory {
    public Payment createPaymentMethod(Map<String, String> params) {
        String cardNumber = params.get("creditcardNumber");
        return new CreditCardPayment(cardNumber);
    }
}

class DebitCardFactory extends PaymentFactory {
    public Payment createPaymentMethod(Map<String, String> params) {
        String cardNumber = params.get("debitcardNumber");
        return new DebitCardPayment(cardNumber);
    }
}

class UPIFactory extends PaymentFactory {
    public Payment createPaymentMethod(Map<String, String> params) {
        String upiId = params.get("upiId");
        return new UPIPayment(upiId);
    }
}

class Main {
    public static void main(String[] args) {
        // Credit Card Payment
        PaymentFactory creditFactory = new CreditCardFactory();
        Map<String, String> creditParams = new HashMap<>();
        creditParams.put("creditcardNumber", "1234-5678-9101-1121");
        Payment creditPayment = creditFactory.createPaymentMethod(creditParams);
        creditPayment.processPayment(1500.0);

        // Debit Card Payment
        PaymentFactory debitFactory = new DebitCardFactory();
        Map<String, String> debitParams = new HashMap<>();
        debitParams.put("debitcardNumber", "4321-8765-1098-2110");
        Payment debitPayment = debitFactory.createPaymentMethod(debitParams);
        debitPayment.processPayment(2000.0);

        // UPI Payment
        PaymentFactory upiFactory = new UPIFactory();
        Map<String, String> upiParams = new HashMap<>();
        upiParams.put("upiId", "user@upi");
        Payment upiPayment = upiFactory.createPaymentMethod(upiParams);
        upiPayment.processPayment(750.0);
    }
}
