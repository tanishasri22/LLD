package structuralPattern.decoratorPattern.waffleDecorator.solution.Decorator.ChocolateDecorator;

import structuralPattern.decoratorPattern.waffleDecorator.solution.BaseWaffle.BaseWaffleClass;

public abstract class ChocolateDecorator extends BaseWaffleClass{
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
