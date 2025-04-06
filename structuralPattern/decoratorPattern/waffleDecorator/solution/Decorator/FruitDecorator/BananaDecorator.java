package structuralPattern.decoratorPattern.waffleDecorator.solution.Decorator.FruitDecorator;

import structuralPattern.decoratorPattern.waffleDecorator.solution.BaseWaffle.BaseWaffleClass;

public class BananaDecorator extends FruitDecorator{
    public BananaDecorator(BaseWaffleClass base){
        baseWaffle = base;
        description = "Banana";
        price = 38;
    }
}
