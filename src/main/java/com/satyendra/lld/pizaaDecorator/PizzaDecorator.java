package com.satyendra.lld.pizaaDecorator;

import java.util.List;

public abstract class PizzaDecorator implements Pizza {
    Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double cost() {
        return pizza.cost();
    }

    @Override
    public String descriptions() {
        return pizza.descriptions();
    }
}
