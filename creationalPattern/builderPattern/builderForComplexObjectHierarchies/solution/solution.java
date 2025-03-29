package creationalPattern.builderPattern.builderForComplexObjectHierarchies.solution;
import java.util.List;
import java.util.ArrayList;

class Computer {
    // Required fields
    private final String processor;
    private final int ram;

    // Optional fields
    private final String graphicsCard;
    private final String storageType;
    private final List<String> additionalPeripherals;

    private Computer(ComputerBuilder builder) {
        this.processor = builder.processor;
        this.ram = builder.ram;
        this.graphicsCard = builder.graphicsCard;
        this.storageType = builder.storageType;
        this.additionalPeripherals = builder.additionalPeripherals;
    }

    public static class ComputerBuilder {
        // Required parameters
        private final String processor;
        private final int ram;

        // Optional parameters with default values
        private String graphicsCard = null;
        private String storageType = null;
        private List<String> additionalPeripherals = new ArrayList<>();

        // Constructor enforcing required fields
        public ComputerBuilder(String processor, int ram) {
            this.processor = processor;
            this.ram = ram;
        }

        // Methods for optional fields
        public ComputerBuilder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public ComputerBuilder setStorageType(String storageType) {
            if (!storageType.equals("HDD") && !storageType.equals("SSD")) {
                throw new IllegalArgumentException("Storage type must be either HDD or SSD.");
            }
            this.storageType = storageType;
            return this;
        }

        public ComputerBuilder addPeripheral(String peripheral) {
            this.additionalPeripherals.add(peripheral);
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "processor='" + processor + '\'' +
                ", ram=" + ram + "GB" +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", storageType='" + storageType + '\'' +
                ", additionalPeripherals=" + additionalPeripherals +
                '}';
    }
}

public class solution {
    public static void main(String[] args) {
        // Computer computer = new Computer.ComputerBuilder("M3PRO", 8).build();

        //DYNAMIC CUSTOMIZATION - Gaming computer with optional fields
        Computer gamingComputer = new Computer.ComputerBuilder("AMD Ryzen 9", 32)
                // .setGraphicsCard("NVIDIA RTX 3080")
                .setStorageType("SSD")
                .addPeripheral("Mechanical Keyboard")
                .addPeripheral("Gaming Mouse")
                .build();
        System.out.println(gamingComputer);
    }
}
