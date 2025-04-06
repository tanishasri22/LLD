package structuralPattern.decoratorPattern.basicImplementation.solution;

import structuralPattern.decoratorPattern.basicImplementation.solution.coffee.Coffee;
import structuralPattern.decoratorPattern.basicImplementation.solution.coffee.Nescafe;
import structuralPattern.decoratorPattern.basicImplementation.solution.decorator.Milk.AlmondMilk;
import structuralPattern.decoratorPattern.basicImplementation.solution.decorator.Milk.Milk;
import structuralPattern.decoratorPattern.basicImplementation.solution.decorator.Sugar.BrownSugar;
import structuralPattern.decoratorPattern.basicImplementation.solution.decorator.Sugar.Sugar;

public class solution {
    public static void main(String[] args) {
        
        Coffee base = new Nescafe();
        System.out.println(base.getDescription() + " " + base.getCost());

        Milk extraMilk = new AlmondMilk(base);
        System.out.println(extraMilk.getDescription() + " " + extraMilk.getCost());

        Sugar extraSugar = new BrownSugar(extraMilk);
        System.out.println(extraSugar.getDescription() + " " + extraSugar.getCost());

        Milk extraExtraMilk = new AlmondMilk(extraSugar);
        System.out.println(extraExtraMilk.getDescription() + " " + extraExtraMilk.getCost());

    }
}
