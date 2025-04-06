package structuralPattern.decoratorPattern.basicImplementation.solution.decorator.Milk;

import structuralPattern.decoratorPattern.basicImplementation.solution.coffee.Coffee;

public class AlmondMilk extends Milk{
    public AlmondMilk(Coffee basecoffee) {
        coffee = basecoffee;
        cost = 30;
        description = "Almond Milk";
    }
}
