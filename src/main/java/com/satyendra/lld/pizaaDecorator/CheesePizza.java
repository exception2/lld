package com.satyendra.lld.pizaaDecorator;

import java.util.List;

public class CheesePizza extends PizzaDecorator {

    public CheesePizza(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double cost() {
        return pizza.cost() + 20.0;
    }

    @Override
    public String descriptions() {
        return pizza.descriptions() + ", Cheese";
    }
}
