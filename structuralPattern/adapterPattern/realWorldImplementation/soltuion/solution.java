package structuralPattern.adapterPattern.realWorldImplementation.soltuion;

// Existing Payment Gateway Interface
interface PaymentGateway {
    void payWithCard(String card);
}

// New Payment Gateway Interface
interface NewPaymentGateway {
    void makeTransaction(String money);
}

// Implementation of the New Payment Gateway
class MakeTransaction implements NewPaymentGateway {
    public void makeTransaction(String card) {
        System.out.println("Making Transaction via new payment method using card " + card);
    }
}

// Adapter that makes NewPaymentGateway compatible with PaymentGateway
class PaymentGatewayAdapter implements PaymentGateway {
    private NewPaymentGateway newPaymentGateway;

    // The adapter initializes the new payment gateway internally
    PaymentGatewayAdapter() {
        this.newPaymentGateway = new MakeTransaction();
    }

    public void payWithCard(String card) {
        System.out.println("Adapting OldPaymentGateway card payment to new system...");
        newPaymentGateway.makeTransaction(card);
    }
}

// Existing Old Payment Gateway
class OldPaymentGateway implements PaymentGateway {
    public void payWithCard(String card) {
        System.out.println("Paying via OldPaymentGateway using " + card);
    }
}

// Driver Class
public class solution {
    public static void main(String[] args) {
        // Client using OldPaymentGateway (unchanged behavior)
        PaymentGateway oldPayment = new OldPaymentGateway();
        oldPayment.payWithCard("SBI");

        // Client using the new system via the Adapter (without knowing about
        // NewPaymentGateway)
        PaymentGateway adaptedPayment = new PaymentGatewayAdapter();
        adaptedPayment.payWithCard("HDFC");
    }
}
