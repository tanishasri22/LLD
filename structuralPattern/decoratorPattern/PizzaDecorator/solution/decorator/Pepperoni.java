package structuralPattern.decoratorPattern.PizzaDecorator.solution.decorator;

import structuralPattern.decoratorPattern.PizzaDecorator.solution.plainPizza.basePizza;

public class Pepperoni extends Decorator{
    public Pepperoni(basePizza basePizza){
        pizza = basePizza;
        price = 29;
        description = "Pepperoni";
    }
}
