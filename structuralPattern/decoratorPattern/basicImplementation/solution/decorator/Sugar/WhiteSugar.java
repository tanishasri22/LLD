package structuralPattern.decoratorPattern.basicImplementation.solution.decorator.Sugar;

import structuralPattern.decoratorPattern.basicImplementation.solution.coffee.Coffee;

public class WhiteSugar extends Sugar{
    
    public WhiteSugar(Coffee basCoffee){
        coffee = basCoffee;
        cost = 23;
        description = "White Sugar";
    }

}
