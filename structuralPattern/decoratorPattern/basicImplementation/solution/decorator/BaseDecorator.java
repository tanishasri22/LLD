package structuralPattern.decoratorPattern.basicImplementation.solution.decorator;

import structuralPattern.decoratorPattern.basicImplementation.solution.coffee.Coffee;

public abstract class BaseDecorator extends Coffee{
    Coffee coffee;

    @Override
    public int getCost() {
        return this.coffee.getCost() + cost;
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription() + ", " + description;
    }
}
