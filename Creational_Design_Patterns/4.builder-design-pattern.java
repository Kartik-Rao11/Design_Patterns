package Creational_Design_Patterns;

/**
 * Builder Design Pattern: It helps in buidling complex objects step by step and
 * then return object.
 * To “Separate the construction of a complex object from its representation so
 * that the same construction process can create different representations.”
 * Builder pattern is used
 * 
 * Working:
 * Uses a separate builder class to construct objects.
 * Allows optional parameters without needing many constructors enabling
 * different representation of objects.
 */
class Computer {
    private String CPU; // private members so that can't be accessed for setting the values
    private String RAM;
    private boolean isGraphicsEnabled;

    static class Builder {
        private String CPU; // private members so that can't be accessed for setting the values
        private String RAM;
        private boolean isGraphicsEnabled;

        // setter functions to build the object step by step
        public Builder setRam(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setIsGraphics(Boolean isGraphicsEnabled) {
            this.isGraphicsEnabled = isGraphicsEnabled;
            return this;
        }

        // after every object properties we call this build that will internally create
        // the computer object through constructor and return the object
        public Computer build() {
            return new Computer(this);
        }
    }

    // constructor private
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.isGraphicsEnabled = builder.isGraphicsEnabled;
    }

    public void showSpecs() {
        System.out.println("CPU: " + CPU + ", RAM: " + RAM + ", Graphics: " + isGraphicsEnabled);
    }

}

class Main {

    public static void main(String[] args) {
        Computer mComputer = new Computer.Builder().setCPU("i7").setRam("12GB").setIsGraphics(true).build();
        mComputer.showSpecs();
    }
}