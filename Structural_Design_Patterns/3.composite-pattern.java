package Structural_Design_Patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * The Composite Pattern organizes objects into tree structures for hierarchical
 * representation.
 * 
 * Working:
 * The Component interface defines operations.
 * Leaf nodes implement the base functionality. (child classes)
 * Composite nodes (containers) hold and operate on child elements. (parent
 * class)
 * 
 * Use Case: File system directories containing folders and files.
 */

interface Employee {
    void showDetails();
}

class Developer implements Employee {
    String name;

    Developer(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("Name " + this.name);
    }
}

// this is parent class that handles child as well
class Manager implements Employee {
    private String name;
    private List<Employee> team = new ArrayList<>();

    Manager(String name) {
        this.name = name;
    }

    public void addEmp(Employee emp) {
        team.add(emp);
    }

    @Override
    public void showDetails() {
        System.out.println("Manager: " + this.name);
        for (Employee emp : team) {
            emp.showDetails();
        }
    }
}

class Main {
    public static void main(String[] args) {
        Developer dev1 = new Developer("Kartik Rao");
        Developer dev2 = new Developer("Random");
        Manager manager = new Manager("Manager1");
        manager.addEmp(dev1);
        manager.addEmp(dev2);
        manager.showDetails();
        // output : Manager: Manager1 (Composite - Parent)
        // ├── Developer: Kartik Rao (Leaf - Child)
        // ├── Developer: Random (Leaf - Child)

        Manager srManager = new Manager("Mr.senior");
        srManager.addEmp(manager);
        srManager.showDetails();
        // Manager: Mr.senior (Parent)
        // ├── Manager: Manager1 (Child Composite)
        // │ ├── Developer: Kartik Rao (Leaf)
        // │ ├── Developer: Random (Leaf)

    }
}
