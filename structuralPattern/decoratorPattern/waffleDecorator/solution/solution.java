package structuralPattern.decoratorPattern.waffleDecorator.solution;

import structuralPattern.decoratorPattern.waffleDecorator.solution.BaseWaffle.BaseWaffleClass;
import structuralPattern.decoratorPattern.waffleDecorator.solution.BaseWaffle.IndianBase;
import structuralPattern.decoratorPattern.waffleDecorator.solution.Decorator.ChocolateDecorator.CaramelChocolate;
import structuralPattern.decoratorPattern.waffleDecorator.solution.Decorator.ChocolateDecorator.DarkChocolate;
import structuralPattern.decoratorPattern.waffleDecorator.solution.Decorator.FruitDecorator.AppleDecorator;
import structuralPattern.decoratorPattern.waffleDecorator.solution.Decorator.FruitDecorator.BananaDecorator;

public class solution {
    public static void main(String[] args) {
        BaseWaffleClass base = new IndianBase();
        System.out.println(base.getDescription() + " " + base.getPrice());

        CaramelChocolate caramel = new CaramelChocolate(base);
        System.out.println(caramel.getDescription() + " "+ caramel.getPrice());

        CaramelChocolate caramelDouble = new CaramelChocolate(caramel);
        System.out.println(caramelDouble.getDescription() + " " + caramelDouble.getPrice());

        DarkChocolate darkChocolate = new DarkChocolate(caramel);
        System.out.println(darkChocolate.getDescription() + " "+darkChocolate.getPrice());

        AppleDecorator appleDecorator = new AppleDecorator(darkChocolate);
        System.out.println(appleDecorator.getDescription() + " " + appleDecorator.getPrice());

        BananaDecorator bananaDecorator = new BananaDecorator(caramel);
        System.out.println(bananaDecorator.getDescription() + " " + bananaDecorator.getPrice());
    }
}
