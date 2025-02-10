package Creational_Design_Patterns;

/*
 * Creational Design Pattern : These patterns foucses on object creation.They
 * aim to enhance flexibility and efficiency in object creation, allowing
 * systems to remain independent of how their objects are constructed, composed,
 * and represented. This approach helps streamline the instantiation process and
 * can lead to more maintainable and adaptable code.
 * 
 * Singleton pattern : Only Single Instance of the class is created and provides global access to it.
 */

class Singleton {
    private static Singleton instance;

    private Singleton() {
    }// private default constructor so can't be instantisated from outside

    public static Singleton getInstance() { // static method to return the method
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("My message");
    }

}

class Main {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        s1.showMessage(); // access the method of class
        System.out.println(s1 == s2); // true

    }
}
