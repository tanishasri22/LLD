package creationalPattern.builderPattern.builderWithDirector.solution;


class HouseDirector {
    public void constructLuxuryHouse(House.HouseBuilder builder) {
        builder.setRooms(5)
                .setWindows(10)
                .setHasGarage(true)
                .setHasSwimmingPool(true);
    }

    public void constructBudgetHouse(House.HouseBuilder builder) {
        builder.setRooms(2)
                .setWindows(4)
                .setHasGarage(false)
                .setHasSwimmingPool(false);
    }
}


public class solution {
    public static void main(String[] args) {
        HouseDirector director = new HouseDirector();

        // Luxury House
        House.HouseBuilder luxuryBuilder = new House.HouseBuilder();
        director.constructLuxuryHouse(luxuryBuilder);
        House luxuryHouse = luxuryBuilder.build();
        System.out.println("Luxury House: " + luxuryHouse);

        // Budget House
        House.HouseBuilder budgetBuilder = new House.HouseBuilder();
        director.constructBudgetHouse(budgetBuilder);
        House budgetHouse = budgetBuilder.build();
        System.out.println("Budget House: " + budgetHouse);

        // Manually Created Custom House
        House customHouse = new House.HouseBuilder()
                .setRooms(3)
                .setWindows(6)
                .setHasGarage(false)
                .setHasSwimmingPool(true)
                .build();
        System.out.println("Custom House: " + customHouse);
    }
}
