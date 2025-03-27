package creationalPattern.builderPattern.solution;

class House{
    private int room;
    private int windows;
    private boolean hasGarage;
    private boolean hasSwimmingPool;

    House(HouseBuilder houseBuilder){
        this.room = houseBuilder.room;
        this.windows = houseBuilder.windows;
        this.hasGarage = houseBuilder.hasGarage;
        this.hasSwimmingPool = houseBuilder.hasSwimmingPool;
    }

    public int getRoom() {
        return room;
    }

    public int getWindows() {
        return windows;
    }

    public boolean getHasGarage(){
        return hasGarage;
    }

    public boolean getHasSwimmingPool() {
        return hasSwimmingPool;
    }

    static class HouseBuilder{
        private int room;
        private int windows;
        private boolean hasGarage;
        private boolean hasSwimmingPool;

        public HouseBuilder(){

        }

        public HouseBuilder setRoom(int roomNum){
            this.room = roomNum;
            return this;
        }

        public HouseBuilder setHasGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public HouseBuilder setHasSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        public HouseBuilder setWindows(int windows) {
            this.windows = windows;
            return this;
        }

        public House build(){
            return new House(this);
        }
    }
}

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
