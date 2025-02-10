package Creational_Design_Patterns;

/**
 * Abstract Factory Pattern : Provides an interface for creating families of
 * related objects without specifying their exact classes.
 * 
 * Working:
 * 
 * Defines a factory for factories.
 * Each factory creates a family of related objects.
 */

// interface
interface Button {
    void render();
}

// concerete implementation classes
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Windows button rendered");
    }
}

class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Mac button rendered");
    }
}

// factory interface
interface GUIFactory {
    Button createButton();
}

// concerte factory classes
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }
}

class Main {
    public static void main(String[] args) {
        GUIFactory factory = new MacFactory();
        // Button button = factory.createButton();
        // button.render(); render mac button
        factory.createButton().render();// renders mac button
    }
}