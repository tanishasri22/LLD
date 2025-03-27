package creationalPattern.factory.abstractMethod.paymentProcessingSystemWithMultipleGateways.solution;

interface CreditCardProcessor {
    void printCreditCardPayment();
}

class PaypalCreditCardProcessor implements CreditCardProcessor{
    public void printCreditCardPayment(){
        System.out.println("Payment done via "+this.getClass().getSimpleName());
    }
}

class StripeCreditCardProcessor implements CreditCardProcessor {
    public void printCreditCardPayment() {
        System.out.println("Payment done via " + this.getClass().getSimpleName());
    }
}

interface UPIProcessor{
    void printUPIPayment();
}

class PaypalUPIProcessor implements UPIProcessor {
    public void printUPIPayment() {
        System.out.println("Payment done via " + this.getClass().getSimpleName());
    }
}

class StripeUPIProcessor implements UPIProcessor {
    public void printUPIPayment() {
        System.out.println("Payment done via " + this.getClass().getSimpleName());
    }
}

interface PaymentFactory{
    CreditCardProcessor getCreditCardProcessor();
    UPIProcessor getUPIProcessor();
}

class PaypalFactory implements PaymentFactory{
    public CreditCardProcessor getCreditCardProcessor(){
        return new PaypalCreditCardProcessor();
    }
    
    public UPIProcessor getUPIProcessor(){
        return new PaypalUPIProcessor();
    }
}

class StripeFactory implements PaymentFactory {
    public CreditCardProcessor getCreditCardProcessor() {
        return new StripeCreditCardProcessor();
    }

    public UPIProcessor getUPIProcessor() {
        return new StripeUPIProcessor();
    }
}


public class solution {
    public static void main(String[] args) {
        PaymentFactory factory = new PaypalFactory();
        CreditCardProcessor ccp = factory.getCreditCardProcessor();
        UPIProcessor upi = factory.getUPIProcessor();

        ccp.printCreditCardPayment();
        upi.printUPIPayment();
    }
}
