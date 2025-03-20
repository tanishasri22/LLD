package creationalPattern.simpleFactory.factoryWithInterfaceForExtension.solution;

interface Notification{
    void sendNotification(String message);
}

class EmailNotification implements Notification{
    public void sendNotification(String message){
        System.out.println("Printing message in Email Notification: "+ message);
    }
}

class SMSNotification implements Notification {
    public void sendNotification(String message) {
        System.out.println("Printing message in SMS Notification: " + message);
    }
}

class PushNotification implements Notification {
    public void sendNotification(String message) {
        System.out.println("Printing message in Push Notification: " + message);
    }
}

class NotificationFactory{
    public static Notification createNotification(String type){
        return switch(type.toLowerCase()){
            case "email" -> new EmailNotification();
            case "sms" -> new SMSNotification();
            case "push" -> new PushNotification();
            default -> throw new IllegalArgumentException();
        };
            // switch (type.toLowerCase()){
            // case "email":
            //     return new EmailNotification();
            // case "sms": 
            //     return new SMSNotification();
            // case "push": 
            //     return new PushNotification();
            // default: 
            //     throw new IllegalArgumentException();
            // }
    }
}


public class solution {
    public static void main(String args[]){
        Notification email = NotificationFactory.createNotification("Email");
        email.sendNotification( "Hi Tanisha, this email notification is for you!");

        Notification push = NotificationFactory.createNotification("Push");
        push.sendNotification("Hi Tanisha, this push notification is for you!");
    }
}
