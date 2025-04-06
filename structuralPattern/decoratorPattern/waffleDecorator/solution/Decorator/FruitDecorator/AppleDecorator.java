package structuralPattern.decoratorPattern.waffleDecorator.solution.Decorator.FruitDecorator;

import structuralPattern.decoratorPattern.waffleDecorator.solution.BaseWaffle.BaseWaffleClass;

public class AppleDecorator extends FruitDecorator{

    public AppleDecorator(BaseWaffleClass base){
        baseWaffle = base;
        description = "Apple";
        price = 37;
    }
    
}
