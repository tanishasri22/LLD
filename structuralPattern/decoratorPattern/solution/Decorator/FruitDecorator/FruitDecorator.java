package structuralPattern.decoratorPattern.solution.Decorator.FruitDecorator;

import structuralPattern.decoratorPattern.solution.BaseWaffle.BaseWaffleClass;

public class FruitDecorator extends BaseWaffleClass{
    BaseWaffleClass baseWaffle;

    @Override
    public String getDescription() {
        return this.baseWaffle.getDescription() + ", " + description;
    }

    @Override
    public int getPrice() {
        return this.baseWaffle.getPrice() + price;
    }
}
