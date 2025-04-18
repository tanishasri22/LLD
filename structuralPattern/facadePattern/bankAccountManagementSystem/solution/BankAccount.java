package structuralPattern.facadePattern.bankAccountManagementSystem.solution;

class User {
    private final String id;
    private final String name;
    private final int contact;
    private final String address;
    private double amount;

    public User(String id, String name, String address, int contact, double amount) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public int getContact() {
        return contact;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public String getAddress() {
        return address;
    }

    public void depositAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        this.amount += amount;
    }

    public void withdrawAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive.");
        }
        this.amount -= amount;
    }
}

class AccountVerification {
    public boolean isUserFound(String userId) {
        System.out.println("Checking database for user with ID: " + userId);
        return true; // Simulated DB check
    }

    public boolean verifyUser(String userId) {
        System.out.println("Verifying user...");
        if (isUserFound(userId)) {
            System.out.println("User verified.");
            return true;
        }
        System.out.println("User not found.");
        return false;
    }
}

class SecurityCodeCheck {
    private int generatedOtp;

    public int sendOtp(User user) {
        generatedOtp = 123456; // Simulated OTP
        System.out.println("Sending OTP to contact: " + user.getContact());
        return generatedOtp;
    }

    public boolean verifyOtp(int inputOtp) {
        if (generatedOtp == inputOtp) {
            System.out.println("OTP verified.");
            return true;
        }
        System.out.println("Incorrect OTP.");
        return false;
    }
}

class FundsCheck {
    public double checkBalance(User user) {
        double balance = user.getAmount();
        System.out.println("Current balance: ₹" + balance);
        return balance;
    }
}

class AccountTransactionService {
    public boolean withdraw(User user, double amount) {
        if (user.getAmount() < amount) {
            System.out.println("Insufficient balance.");
            return false;
        }
        System.out.println("Withdrawing ₹" + amount + " from " + user.getName() + "'s account.");
        user.withdrawAmount(amount);
        return true;
    }

    public void deposit(User user, double amount) {
        System.out.println("Depositing ₹" + amount + " to " + user.getName() + "'s account.");
        user.depositAmount(amount);
    }
}

class BankAccountFacade {
    private final AccountVerification verifier = new AccountVerification();
    private final SecurityCodeCheck otpChecker = new SecurityCodeCheck();
    private final FundsCheck fundsChecker = new FundsCheck();
    private final AccountTransactionService transactionService = new AccountTransactionService();

    public void withdraw(User user, double amount) {
        System.out.println("\n=== WITHDRAWAL REQUEST ===");
        if (!verifier.verifyUser(user.getId()))
            return;

        int otp = otpChecker.sendOtp(user);
        if (!otpChecker.verifyOtp(otp))
            return;

        fundsChecker.checkBalance(user);

        if (transactionService.withdraw(user, amount)) {
            System.out.println("Withdrawal successful. New balance: ₹" + user.getAmount());
        }
    }

    public void deposit(User user, double amount) {
        System.out.println("\n=== DEPOSIT REQUEST ===");
        if (!verifier.verifyUser(user.getId()))
            return;

        int otp = otpChecker.sendOtp(user);
        if (!otpChecker.verifyOtp(otp))
            return;

        fundsChecker.checkBalance(user);

        transactionService.deposit(user, amount);
        System.out.println("Deposit successful. New balance: ₹" + user.getAmount());
    }
}

public class BankAccount {
    public static void main(String[] args) {
        User user = new User("95673", "Tanisha", "Sector 22, Gurgaon", 99234, 5000);

        BankAccountFacade bankAccount = new BankAccountFacade();
        bankAccount.withdraw(user, 500);
        bankAccount.deposit(user, 400);
        bankAccount.withdraw(user, 6000); // Insufficient balance
    }
}
