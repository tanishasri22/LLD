package structuralPattern.decoratorPattern.basicImplementation.solution.decorator;

import structuralPattern.decoratorPattern.basicImplementation.solution.coffee.Coffee;

public class Milk extends BaseDecorator{

    public Milk(Coffee basecoffee) {
        coffee = basecoffee;
        cost = 30;
        description = "Milk";
    }
    
}
