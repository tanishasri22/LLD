package structuralPattern.decoratorPattern.basicImplementation.solution.decorator.Sugar;

import structuralPattern.decoratorPattern.basicImplementation.solution.coffee.Coffee;

public class BrownSugar extends Sugar{
    
    public BrownSugar(Coffee basCoffee){
        coffee = basCoffee;
        cost = 17;
        description = "Brown Sugar";
    }

}
