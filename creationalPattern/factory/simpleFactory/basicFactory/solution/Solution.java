package creationalPattern.factory.simpleFactory.basicFactory.solution;

interface Vehicle {
    void move();
}

class Car implements Vehicle {
    public void move() {
        System.out.println(this.getClass().getSimpleName() + "is moving");
    }
}

class Bike implements Vehicle {
    public void move() {
        System.out.println(this.getClass().getSimpleName() + "is moving");
    }
}

class Truck implements Vehicle {
    public void move() {
        System.out.println(this.getClass().getSimpleName() + "is moving");
    }
}

class simpleFactory {
    public static Vehicle simpleFactoryCreate(String vehicle) {
        if (vehicle.equals("Car"))
            return new Car();
        else if (vehicle.equals("Bike"))
            return new Bike();
        else if (vehicle.equals("Truck"))
            return new Truck();
        else
            throw new IllegalArgumentException();
    }
}

public class Solution {
    public static void main(String args[]) {
        Vehicle car = simpleFactory.simpleFactoryCreate("Car");
        car.move();
    }
}
