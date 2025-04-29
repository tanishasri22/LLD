package behaviouralPattern.strategyPattern.basicBehaviouralPattern.solution;

interface PaymentStrategy{
    void pay();
}

class CreditCardProcessor implements PaymentStrategy{
    
    public void pay(){
        System.out.println("Processing via "+ this.getClass().getSimpleName());
    }
}

class PayPalProcessor implements PaymentStrategy{
    public void pay() {
        System.out.println("Processing via " + this.getClass().getSimpleName());
    }
}

class CryptoCurrencyProcessor implements PaymentStrategy {
    public void pay() {
        System.out.println("Processing via " + this.getClass().getSimpleName());
    }
}

class GeneralProcessor implements PaymentStrategy {
    public void pay() {
        System.out.println("Processing via " + this.getClass().getSimpleName());
    }
}

class PaymentService{
    PaymentStrategy payment;

    PaymentService(PaymentStrategy payment){
        this.payment = payment;
    }

    void pay(){
        payment.pay();
    }
}

class CreditCardService extends PaymentService{
    CreditCardService(PaymentStrategy paymentStrategy){
        super(paymentStrategy);
    }

    @Override
    void pay(){
        System.out.println("Using Credit Card Service to initiate payment :");
        super.pay();
    }
}

class PayPalService extends PaymentService {
    PayPalService(PaymentStrategy paymentStrategy) {
        super(paymentStrategy);
    }

    @Override
    void pay() {
        System.out.println("Using PayPal Service to initiate payment :");
        super.pay();
    }
}

class CryptoCurrencyService extends PaymentService {
    CryptoCurrencyService(PaymentStrategy paymentStrategy) {
        super(paymentStrategy);
    }

    @Override
    void pay() {
        System.out.println("Using CryptoCurrency Service to initiate payment :");
        super.pay();
    }
}

public class solution {

    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService(new CreditCardProcessor());
        paymentService.pay();
        System.out.println("\n");

        PaymentService creditCardPaymentService = new CreditCardService(new CreditCardProcessor());
        creditCardPaymentService.pay();
        System.out.println("\n");

        PaymentService paypPaymentService = new PayPalService(new PayPalProcessor());
        paypPaymentService.pay();
        System.out.println("\n");

        PaymentService paypPaymentServiceForGeneralProc = new PayPalService(new GeneralProcessor());
        paypPaymentServiceForGeneralProc.pay();
        System.out.println("\n");
    }
}