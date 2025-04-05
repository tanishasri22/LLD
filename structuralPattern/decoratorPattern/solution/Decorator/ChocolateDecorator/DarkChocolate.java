package structuralPattern.decoratorPattern.solution.Decorator.ChocolateDecorator;

import structuralPattern.decoratorPattern.solution.BaseWaffle.BaseWaffleClass;

public class DarkChocolate extends ChocolateDecorator{

    public DarkChocolate(BaseWaffleClass base){
        baseWaffle = base;
        description = "DarkChocolate";
        price = 55;
    }
}
