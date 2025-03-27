package creationalPattern.factory.factoryMethod.basicFactoryMethod.solutions;

interface Payment {
    double processPayment(float amount);
}

class CreditCardPayment implements Payment {
    public double processPayment(float amount) {
        System.out.println("Returing the " + this.getClass().getSimpleName() + " amount: " + amount);
        return amount + 50.0;
    }
}

class DebitCardPayment implements Payment {
    public double processPayment(float amount) {
        System.out.println("Returing the " + this.getClass().getSimpleName() + " amount: " + amount);
        return amount + 70.0;
    }
}

class UPIPayment implements Payment {
    public double processPayment(float amount) {
        System.out.println("Returing the " + this.getClass().getSimpleName() + " amount: " + amount);
        return amount + 100.0;
    }
}

interface PaymentFactory {
    Payment createPaymentMethod();
}

class CreditCardFactory implements PaymentFactory {
    public Payment createPaymentMethod() {
        return new CreditCardPayment();
    }
}

class DebitCardFactory implements PaymentFactory {
    public Payment createPaymentMethod() {
        return new DebitCardPayment();
    }
}

class UPIFactory implements PaymentFactory {
    public Payment createPaymentMethod() {
        return new UPIPayment();
    }
}

public class solution {
    public static void main(String[] args) {
        PaymentFactory factory = new CreditCardFactory();
        Payment payment = factory.createPaymentMethod();
        System.out.println(payment.processPayment(0));

        PaymentFactory factory2 = new DebitCardFactory();
        Payment payment2 = factory2.createPaymentMethod();
        System.out.println(payment2.processPayment(0));
    }

}
