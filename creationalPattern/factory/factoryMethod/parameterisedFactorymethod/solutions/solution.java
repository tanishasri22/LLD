package creationalPattern.factory.factoryMethod.parameterisedFactorymethod.solutions;

interface Payment{
    double processPayment(float amount);
}

class CreditCard implements Payment{
    String UPINumber;

    CreditCard(String UPINumber){
        this.UPINumber = UPINumber;
    }

    public double processPayment(float amount){
        System.out.println("Processing on amount of "+ this.getClass().getSimpleName()+": "+amount);
        return amount + 50;
    }

     String getMaskedUpiNumber(){
        return "xxxx"+UPINumber.substring(UPINumber.length()-4);
    }
}

class DebitCard implements Payment{
    String DebitNumber;

    DebitCard(String DebitNumber){
        this.DebitNumber = DebitNumber;
    }

    public double processPayment(float amount) {
        System.out.println("Processing on amount of " + this.getClass().getSimpleName() + ": " + amount);
        return amount + 80;
    }
}

class UPIPayment implements Payment {
    String UPINumber;

    UPIPayment(String UPINumber){
        this.UPINumber = UPINumber;
    }

    public double processPayment(float amount) {
        System.out.println("Processing on amount of " + this.getClass().getSimpleName() + ": " + amount);
        return amount + 150;
    }
}

interface PaymentFactory{
    Payment createPaymentMethod(String details);
}

class CreditCardPaymentFactory implements PaymentFactory{
    public Payment createPaymentMethod(String UPINumber){
        return new CreditCard(UPINumber);
    }
}

class DebitCardPaymentFactory implements PaymentFactory {
    public Payment createPaymentMethod(String UPINumber) {
        return new DebitCard(UPINumber);
    }
}

class UPIPaymentFactory implements PaymentFactory {
    public Payment createPaymentMethod(String UPINumber) {
        return new UPIPayment(UPINumber);
    }
}

public class solution {
    public static void main(String[] args) {

        /* in case we want to explicitly access the data members of non-factory internal child class
         (eg: CreditCard) which ideally would violate the encapsulation but in some extreme cases 
         we might need. for eg: We shouldn't be able to access UPI Number from client class but 
         displaying masked UPI details will need. – e.g., showing a confirmation message like: "Payment
         processed using UPI ID ending in 1234."
         */

        PaymentFactory factory = new CreditCardPaymentFactory();
        CreditCard creditCardPayment = (CreditCard) factory.createPaymentMethod("DCSN2342I590");
        creditCardPayment.processPayment(456);
        creditCardPayment.getMaskedUpiNumber();

        PaymentFactory factory2 = new CreditCardPaymentFactory();
        Payment debitCardPayment = factory2.createPaymentMethod("DCSN2342I590");
        debitCardPayment.processPayment(343);
    }
}
