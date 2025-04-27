package creationalPattern.builderPattern.builderForComplexObjectHierarchies.solution;

import java.util.ArrayList;
import java.util.List;

class Peripheral implements Cloneable {
    private String name;
    private double price;

    public Peripheral(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Copy constructor for deep copy
    public Peripheral(Peripheral other) {
        this.name = other.name;
        this.price = other.price;
    }

    @Override
    public Peripheral clone() {
        return new Peripheral(this);
    }

    @Override
    public String toString() {
        return "Peripheral{name='" + name + "', price=" + price + "}";
    }
}

public class Computer implements Cloneable {

    private final String processor;
    private final int ram;

    private final String graphicsCard;
    private final String storageType;
    private final List<Peripheral> additionalPeripherals;

    private Computer(Builder builder) {
        this.processor = builder.processor;
        this.ram = builder.ram;
        this.graphicsCard = builder.graphicsCard;
        this.storageType = builder.storageType;
        this.additionalPeripherals = builder.additionalPeripherals;
    }

    public static class Builder {
        private final String processor;
        private final int ram;

        private String graphicsCard;
        private String storageType;
        private List<Peripheral> additionalPeripherals = new ArrayList<>();

        public Builder(String processor, int ram) {
            this.processor = processor;
            this.ram = ram;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setStorageType(String storageType) {
            this.storageType = storageType;
            return this;
        }

        public Builder addPeripheral(Peripheral peripheral) {
            this.additionalPeripherals.add(peripheral);
            return this;
        }

        public Builder setAdditionalPeripherals(List<Peripheral> peripherals) {
            this.additionalPeripherals = new ArrayList<>(peripherals);
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public Computer clone() {
        List<Peripheral> clonedPeripherals = new ArrayList<>();
        for (Peripheral p : this.additionalPeripherals) {
            clonedPeripherals.add(p.clone());
        }

        return new Builder(this.processor, this.ram)
                .setGraphicsCard(this.graphicsCard)
                .setStorageType(this.storageType)
                .setAdditionalPeripherals(clonedPeripherals)
                .build();
    }

    @Override
    public String toString() {
        return "Computer{" +
                "processor='" + processor + '\'' +
                ", ram=" + ram +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", storageType='" + storageType + '\'' +
                ", additionalPeripherals=" + additionalPeripherals +
                '}';
    }
}


class Main {
    public static void main(String[] args) {
        Peripheral keyboard = new Peripheral("Mechanical Keyboard", 120.0);
        Peripheral mouse = new Peripheral("Gaming Mouse", 80.0);
        List<Peripheral> list = new ArrayList<>();
        list.add(keyboard);
        list.add(mouse);
        Computer original = new Computer.Builder("AMD Ryzen 9", 32)
                .setGraphicsCard("NVIDIA RTX 4080")
                .setStorageType("SSD")
                .setAdditionalPeripherals(list)
                .addPeripheral(keyboard)
                .addPeripheral(mouse)
                .build();

        System.out.println("Original:\n" + original);

        // Clone the computer
        Computer clone = original.clone();

        System.out.println("\nCloned:\n" + clone);
    }
}
