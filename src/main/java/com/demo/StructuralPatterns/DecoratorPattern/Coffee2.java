package com.demo.StructuralPatterns.DecoratorPattern;

interface Coffee {
    double cost();
}

class SimpleCoffee implements Coffee {

    @Override
    public double cost() {
        return 2;
    }
}

abstract class Decorator implements Coffee {
    protected Coffee coffee;

    public Decorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public double cost() {
        return coffee.cost() + 0.5;
    }
}

class MilkDecorator extends Decorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public double cost() {
        return coffee.cost() + 0.25;
    }
}

class SugarDecorator extends Decorator {

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public double cost() {
        return coffee.cost() + 0.3;
    }
}
public class Coffee2 {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        Coffee coffeeWithMilk = new MilkDecorator(coffee);
        Coffee coffeeWithMilkAndSugar = new SugarDecorator(coffeeWithMilk);

        System.out.println("Coffee cost: " + coffee.cost());
        System.out.println("Coffee with Milk cost: " + coffeeWithMilk.cost());
        System.out.println("Coffee with Milk and Sugar cost: " + coffeeWithMilkAndSugar.cost());
    }
}
