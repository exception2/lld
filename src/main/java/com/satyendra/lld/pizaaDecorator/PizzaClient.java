package com.satyendra.lld.pizaaDecorator;

public class PizzaClient {
    public static void main(String[] args) {
        Pizza pizza = new PlainPizza();
        System.out.println(pizza.cost() + " " + pizza.descriptions());

        pizza = new CheesePizza(pizza);
        System.out.println(pizza.cost() + " " + pizza.descriptions());

        pizza = new MashroomPizza(pizza);
        System.out.println(pizza.cost() + " " + pizza.descriptions());
    }
}
