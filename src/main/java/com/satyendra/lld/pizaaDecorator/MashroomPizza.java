package com.satyendra.lld.pizaaDecorator;

public class MashroomPizza extends PizzaDecorator {
    public MashroomPizza(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double cost() {
        return pizza.cost() + 30.0;
    }

    @Override
    public String descriptions() {
        return pizza.descriptions() + ", Mashroom";
    }
}
