package Structural_Design_Patterns;

/**
 * The Adapter Pattern allows objects with incompatible interfaces to work
 * together by providing an intermediary that translates requests.
 * 
 * Working
 * The Adapter converts one interface into another.
 * The Client interacts with the adapter, which delegates calls to the existing
 * system.
 * Use Case: Using legacy database drivers with a modern API.
 */

// 1st interface (incompatible)
interface OldInterface {
    void chargeWithTwoPins();
}

// 1st class implementation
class OldCharger implements OldInterface {
    @Override
    public void chargeWithTwoPins() {
        System.out.println("Chargin with old charger ");
    }
}

interface NewInterface {
    void chargeWithThreePins();
}

// this class is new charger but only works with old charger
class NewCharger implements NewInterface {
    private OldCharger oldCharger; // this will act as adapter between old and new interface

    NewCharger(OldCharger oldCharger) {
        this.oldCharger = oldCharger;
    }

    @Override
    public void chargeWithThreePins() {
        System.out.println("adapting to chargin with 2 pins instead of three");
        oldCharger.chargeWithTwoPins(); // calling the old method due to DI of old charger
    }
}

class Main {
    public static void main(String[] args) {
        OldCharger oldCharger = new OldCharger();
        NewCharger newCharger = new NewCharger(oldCharger);
        newCharger.chargeWithThreePins();
        // output : adapting to chargin with 2 pins instead of three
        // Chargin with old charger

    }
}
