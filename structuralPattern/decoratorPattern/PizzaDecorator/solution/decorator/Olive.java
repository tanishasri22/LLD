package structuralPattern.decoratorPattern.PizzaDecorator.solution.decorator;

import structuralPattern.decoratorPattern.PizzaDecorator.solution.plainPizza.basePizza;

public class Olive extends Decorator {

    public Olive(basePizza basePizza) {
        pizza = basePizza;
        price = 41; // decorator
        description = "Olive"; // decorator
    }
}