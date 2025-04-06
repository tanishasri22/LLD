package structuralPattern.decoratorPattern.basicImplementation.solution.decorator;

import structuralPattern.decoratorPattern.basicImplementation.solution.coffee.Coffee;

public class Sugar extends BaseDecorator{
    public Sugar(Coffee basCoffee){
        coffee = basCoffee;
        cost = 15;
        description = "Sugar";
    }
}
