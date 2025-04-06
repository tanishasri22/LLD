package structuralPattern.decoratorPattern.basicImplementation.solution;

import structuralPattern.decoratorPattern.basicImplementation.solution.coffee.Coffee;
import structuralPattern.decoratorPattern.basicImplementation.solution.coffee.Nescafe;
import structuralPattern.decoratorPattern.basicImplementation.solution.decorator.Milk;
import structuralPattern.decoratorPattern.basicImplementation.solution.decorator.Sugar;

public class solution {
    public static void main(String[] args) {
        
        Coffee base = new Nescafe();
        System.out.println(base.getDescription() + " " + base.getCost());

        Milk extraMilk = new Milk(base);
        System.out.println(extraMilk.getDescription() + " " + extraMilk.getCost());

        Sugar extraSugar = new Sugar(extraMilk);
        System.out.println(extraSugar.getDescription() + " " + extraSugar.getCost());
    }
}
