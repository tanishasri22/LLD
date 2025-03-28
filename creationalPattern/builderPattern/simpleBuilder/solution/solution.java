package creationalPattern.builderPattern.simpleBuilder.solution;


public class solution {
    public static void main(String[] args) {
        House house = new House.HouseBuilder()
                        .setHasGarage(true)
                        .setRoom(4)
                        .build();
        System.out.println("Getting rooms: " + house.getRoom());
        System.out.println("Getting hasGarage: " + house.getHasGarage());

        
        
    }
}
