package structuralPattern.decoratorPattern.solution.Decorator.ChocolateDecorator;

import structuralPattern.decoratorPattern.solution.BaseWaffle.BaseWaffleClass;

public class CaramelChocolate extends ChocolateDecorator {

    public CaramelChocolate(BaseWaffleClass base) {
        baseWaffle = base;
        description = "Caramel";
        price = 40;
    }
}
