package creationalPattern.builderPattern.builderWithDirector.solution;
import creationalPattern.builderPattern.simpleBuilder.solution.House;

class HouseDirector {
    public void constructLuxuryHouse(House.HouseBuilder builder) {
        builder.setRoom(5)
                .setWindows(10)
                .setHasGarage(true)
                .setHasSwimmingPool(true);
    }

    public void constructBudgetHouse(House.HouseBuilder builder) {
        builder.setRoom(2)
                .setWindows(4)
                .setHasGarage(false)
                .setHasSwimmingPool(false);
    }
}


public class Solution {
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
                .setRoom(3)
                .setWindows(6)
                .setHasGarage(false)
                .setHasSwimmingPool(true)
                .build();
        System.out.println("Custom House: " + customHouse);
    }
}
