package Structural_Design_Patterns;

/**
 * The Bridge Pattern separates abstraction from implementation, allowing
 * changes in both independently.
 * 
 * Working
 * A Bridge (interface) connects an Abstraction (higher level) with
 * Implementations.
 * This removes the tight coupling between abstraction and implementation.
 */

interface Color {
    void applyColor();
}

class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Coloring it red...");
    }
}

// this is a abstract class that has method draw
abstract class Shape {

    protected Color color; // we are injecting color interface to allow bridging b/w different color
                           // objects. Also Changing in the shape class won't affect the Color
                           // implementations. (Loose coupling)

    Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}

class Circle extends Shape { // Circle extends shape (abstract class) forcing it implementing the default
                             // constructor and draw method

    Circle(Color color) { // we pass the color object that object is passed in the Shape's contructor
                          // using super(color)
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
        color.applyColor(); // calling the methods of the color object
        // adding new colors or changing the Shape class won't affect each other
    }
}

class Main {
    public static void main(String[] args) {
        Color reColor = new RedColor(); // creating a color class
        Circle circle = new Circle(reColor); // sending it to circle class
        circle.draw();
        // output : Drawing Circle, Coloring it red...
    }
}