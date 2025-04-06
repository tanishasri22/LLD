package structuralPattern.decoratorPattern.waffleDecorator.solution.BaseWaffle;

public abstract class BaseWaffleClass {
    protected int price;
    protected String description = "";

    public String getDescription(){
        return this.description;
    }

    public int getPrice() {
        return price;
    }
} 
