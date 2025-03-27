package creationalPattern.factory.simpleFactory.factoryWithParameterisedObjects.solution;

// Abstract class for Vehicles
abstract class Vehicle {
    protected int speed;
    protected String fuelType;

    public Vehicle(int speed, String fuelType) {
        this.speed = speed;
        this.fuelType = fuelType;
    }

    public abstract void move();

    public void displayInfo() {
        System.out.println(getClass().getSimpleName() + " | Speed: " + speed + " | Fuel Type: " + fuelType);
    }
}

// Concrete classes for different vehicles
class Car extends Vehicle {
    public Car(int speed, String fuelType) {
        super(speed, fuelType);
    }

    @Override
    public void move() {
        System.out.println("Car is moving smoothly.");
    }
}

class Truck extends Vehicle {
    public Truck(int speed, String fuelType) {
        super(speed, fuelType);
    }

    @Override
    public void move() {
        System.out.println("Truck is moving with a heavy load.");
    }
}

class Bike extends Vehicle {
    public Bike(int speed, String fuelType) {
        super(speed, fuelType);
    }

    @Override
    public void move() {
        System.out.println("Bike is moving swiftly.");
    }
}

// Factory class to create vehicles
class VehicleFactory {
    public static Vehicle createVehicle(String type, int speed, String fuelType) {
        return switch (type.toLowerCase()) {
            case "car" -> new Car(speed, fuelType);
            case "truck" -> new Truck(speed, fuelType);
            case "bike" -> new Bike(speed, fuelType);
            default -> throw new IllegalArgumentException("Unknown vehicle type: " + type);
        };
    }
}

// Client code
public class FactoryWithBestCase {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.createVehicle("Car", 60, "Petrol");
        car.move();
        car.displayInfo();

        Vehicle truck = VehicleFactory.createVehicle("Truck", 40, "Diesel");
        truck.move();
        truck.displayInfo();

        Vehicle bike = VehicleFactory.createVehicle("Bike", 80, "Electric");
        bike.move();
        bike.displayInfo();
    }
}
