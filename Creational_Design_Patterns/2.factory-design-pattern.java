package Creational_Design_Patterns;
/*
 * Factory Design Patterns : It provide an interface for object
 * creation without defining the concerte class implementaion.
 * Objects are created through a factory class and based on client input
 */

interface Notification { // interface for object creation
    public void showMessage();
}

class EmailNotification implements Notification { // common classes that implements the same interface
    @Override
    public void showMessage() {
        System.out.println("EMAIL notification sent");
    }
}

class SMSNotification implements Notification {
    @Override
    public void showMessage() {
        System.out.println("SMS notification sent");
    }
}

class NotificationFactory { // factory class without concerte implmentation
    String type;

    public static Notification createNotification(String type) {
        if (type == "email") {
            return new EmailNotification(); // returning object based on the inputs
        } else {
            return new SMSNotification();
        }
    }
}

class Main {
    public static void main(String[] args) {
        Notification myNotification = NotificationFactory.createNotification("email"); // main class creating object
                                                                                       // based on the create
                                                                                       // notification function
        myNotification.showMessage();
    }
}

// use case : Payement Gateways, Notification system