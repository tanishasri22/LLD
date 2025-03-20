package creationalPattern.simpleFactory.basicFactory.solution;

interface Vehicle {
    void move();
}

class Car implements Vehicle {
    public void move() {
        System.out.println("Car is moving");
    }
}

class Bike implements Vehicle {
    public void move() {
        System.out.println("Bike is moving");
    }
}

class Truck implements Vehicle {
    public void move() {
        System.out.println("Truck is moving");
    }
}

class simpleFactory {
    public static Vehicle simpleFactoryCreate(String vehicle) {
        if (vehicle.compareTo("Car") == 0)
            return new Car();
        else if (vehicle.compareTo("Bike") == 0)
            return new Bike();
        else
            return new Truck();
    }
}

public class Solution {
    public static void main(String args[]) {
        Vehicle car = simpleFactory.simpleFactoryCreate("Car");
        car.move();
    }
}
