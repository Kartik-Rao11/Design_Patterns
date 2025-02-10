package Creational_Design_Patterns;

/*
 * Definition: Allows cloning objects without depending on their concrete
 * classes.
 * 
 * Working:
 * 
 * A class implements the Cloneable interface.
 * The clone() method duplicates objects.
 */

class Vehicle implements Cloneable {
    public String type;

    public Vehicle(String type) {
        this.type = type;
    }

    public Vehicle clone() throws CloneNotSupportedException {
        return (Vehicle) super.clone();
    }

    public void showType() {
        System.out.println("Vehicle Type: " + type);
    }
}

class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Vehicle car = new Vehicle("Car");
        Vehicle clonedCar = car.clone();

        car.showType(); // Output: Vehicle Type: Car
        clonedCar.showType(); // Output: Vehicle Type: Car
    }
}
