package structuralPattern.decoratorPattern.basicImplementation.solution.decorator.Milk;

import structuralPattern.decoratorPattern.basicImplementation.solution.coffee.Coffee;

public class CowMilk extends Milk{

    public CowMilk(Coffee basecoffee) {
        coffee = basecoffee;
        cost = 26;
        description = "Cow Milk";
    }

}