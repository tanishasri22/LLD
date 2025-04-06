package structuralPattern.decoratorPattern.waffleDecorator.solution.Decorator.ChocolateDecorator;

import structuralPattern.decoratorPattern.waffleDecorator.solution.BaseWaffle.BaseWaffleClass;

public class DarkChocolate extends ChocolateDecorator{

    public DarkChocolate(BaseWaffleClass base){
        baseWaffle = base;
        description = "DarkChocolate";
        price = 55;
    }
}
