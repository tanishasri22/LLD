package structuralPattern.decoratorPattern.PizzaDecorator.solution.decorator;

import structuralPattern.decoratorPattern.PizzaDecorator.solution.plainPizza.basePizza;

public class Decorator extends basePizza{
    basePizza pizza;

    @Override
    public String getDescription() {
        return this.pizza.getDescription() + ", " + description;
    }

    @Override
    public int getPrice() {
        return this.pizza.getPrice() + price;
    }
}
