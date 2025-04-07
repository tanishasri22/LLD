package structuralPattern.decoratorPattern.PizzaDecorator.solution.plainPizza;

public abstract class basePizza {
    protected int price;
    protected String description = "";

    public String getDescription() {
        return this.description;
    }

    public int getPrice() {
        return this.price;
    }
}
