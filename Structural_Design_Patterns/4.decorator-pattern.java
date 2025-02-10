package Structural_Design_Patterns;

/*
 * The Decorator Pattern allows adding new functionality dynamically without
 * modifying the existing code.
 * 
 * Working
 * Component defines the base behavior. (Interface)
 * Concrete Component implements it.(The class or base class)
 * Decorator wraps the object and adds behavior. (can be called wrapper class
 * providing extra functionalities)
 * 
 * Use Case: Extending UI components dynamically.
 */

interface Car {
    void assemble();
}

// concrete class 1
class BasicCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Assembling basic car");
    }
}

// decorator class
class CarDecorator implements Car {
    protected Car car;

    public CarDecorator(Car car) { // inject the instance of original car or basic
        this.car = car;
    }

    @Override
    public void assemble() { // decorator's class own function, this function is called in different classes
                             // to add functionality dynamically
        car.assemble(); // basic car's assemble function
    }

}

// class on where we are using CarDecorator
class SuperCar extends CarDecorator {

    public SuperCar(Car car) { // Contrusctor getting the values of Car
        super(car); // calling the decorator's class constructor that initialize the Car's class
    }

    @Override
    public void assemble() {
        super.assemble(); // calling the originar car assemble function using decorator's function
        System.out.println("Adding functionalities of super car");
    }
}

class Main {
    public static void main(String[] args) {
        SuperCar superCar = new SuperCar(new BasicCar());
        superCar.assemble();
        // output : Assembling basic car, Adding features of a Sports Car
    }
}
