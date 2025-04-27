package structuralPattern.bridgePattern.messagingSystem.solution;

// Bridge Interface
interface MessageSender {
    void send(String content);
}

// Concrete Implementations
class EmailSender implements MessageSender {
    @Override
    public void send(String content) {
        System.out.println("Sending via Email: " + content);
    }
}

class SmsSender implements MessageSender {
    @Override
    public void send(String content) {
        System.out.println("Sending via SMS: " + content);
    }
}

// Abstraction
abstract class Message {
    protected final MessageSender messageSender;

    public Message(MessageSender messageSender) {
        if (messageSender == null) {
            throw new IllegalArgumentException("MessageSender cannot be null");
        }
        this.messageSender = messageSender;
    }

    public abstract void writeMessage(String content);
}

// Refined Abstractions
class TextMessage extends Message {
    public TextMessage(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void writeMessage(String content) {
        messageSender.send("[TEXT] " + content);
    }
}

class AlertMessage extends Message {
    public AlertMessage(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void writeMessage(String content) {
        messageSender.send("[ALERT] " + content);
    }
}

// Demo
public class MessagingSystemDemo {
    public static void main(String[] args) {
        MessageSender emailSender = new EmailSender();
        MessageSender smsSender = new SmsSender();

        Message msg1 = new TextMessage(emailSender);
        msg1.writeMessage("Hi, Tanisha here!");

        Message msg2 = new AlertMessage(smsSender);
        msg2.writeMessage("⚠️ Server CPU usage at 99%");
    }
}
