package structuralPattern.decoratorPattern.PizzaDecorator.solution.decorator;

import structuralPattern.decoratorPattern.PizzaDecorator.solution.plainPizza.basePizza;

public class Cheese extends Decorator{
    
    public Cheese(basePizza basePizza){
        pizza = basePizza;
        price = 35; //decorator
        description = "Cheese"; // decorator
    }
}
