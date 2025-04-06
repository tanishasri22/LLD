package structuralPattern.decoratorPattern.basicImplementation.solution.coffee;

public abstract class Coffee {
    protected int cost;
    protected String description;

    public int getCost() {
        return this.cost;
    }

    public String getDescription() {
        return this.description;
    }
}
