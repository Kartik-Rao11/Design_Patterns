package Structural_Design_Patterns;

/*
 * 
 * The Flyweight Pattern reduces memory usage by sharing common objects instead
 * of creating new ones for every request.
 * 
 * Working
 * A Flyweight Factory manages a pool of reusable objects.
 * When a Client requests an object, the factory returns an existing one if
 * available, else creates a new one.
 * Intrinsic state (shared data) remains constant, while extrinsic state
 * (context-specific data) varies.
 * 
 */
import java.util.HashMap;
import java.util.Map;

// Flyweight Interface
interface Shape {
    void draw(String color); // Extrinsic state: color
}

// Concrete Flyweight (Shared Object)
class Circle implements Shape {
    private final String shapeType = "Circle"; // Intrinsic state (constant)

    @Override
    public void draw(String color) {
        System.out.println("Drawing " + shapeType + " with color: " + color);
    }
}

// Flyweight Factory (Manages object reuse)
class ShapeFactory {
    private static final Map<String, Shape> shapeMap = new HashMap<>();

    public static Shape getCircle() {
        if (!shapeMap.containsKey("circle")) {
            shapeMap.put("circle", new Circle());
            System.out.println("Creating a new Circle object");
        }
        return shapeMap.get("circle");
    }
}

// Client Code
class Main {
    public static void main(String[] args) {
        Shape circle1 = ShapeFactory.getCircle();
        circle1.draw("Red");
        // Output: Creating a new Circle object
        // Output: Drawing Circle with color: Red

        Shape circle2 = ShapeFactory.getCircle();
        circle2.draw("Blue");
        // Output: Drawing Circle with color: Blue

        System.out.println(circle1 == circle2); // true (Same object is reused)
    }
}
