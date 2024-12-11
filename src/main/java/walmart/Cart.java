package walmart;


import org.apache.tomcat.util.digester.Rule;

import java.util.List;
import java.util.Stack;

/*
Design a feature that will be used by a Shopping cart service to enforce rules on the order

Offer free 2 day shipping on orders > $35 if customer is not a prime member
Offer free 2 day shipping on all orders if customer is a prime member
Offer free 1 day shipping for order that are > $125
Offer free 2 hour shipping for prime customer that have > $25 and the items are grocery items

only one offer is applicable (priority basis)
some more rules can be added

Make this extensible to add other rules in the future Apply a 10% discount on all electronics

free 2 day shipping  -> TV : 10 days - shipping cost
10 items > 35$ >
offers >
e-commerce
Shopping cart service

Requirement:
Apply rule before checking out shopping cart


Models
1. Shopping cart
    - List of items
    - rule
    - shippingFee

2. Item(name, price, quantity, category)
    - name
    - price
    - quantity
    - category(enum)

3. Rule
    - cartValue
    - isPrime
    - category
    - offer
    - priority

4. User
    - name
    - isPrime
    - deliverLocation



* */
public class Cart {
}

class ShoppingCart {

    private String id;
    private Rule rule;
    private double shippingFee;
    private List<Item> itmes;

    public void addItem(Item item) {
        itmes.add(item);
    }
}

class Item {
    private String name;
    private double price;
    private String category;
    private int quantity;
}


class Rule1 {

    private double cartValue;
    private boolean isPrime;
    private String category;
    private String offer;
    private int priority;

    private Rule nextRule;
}

interface RuleStrategy {
    Rule applyRule(ShoppingCart shoppingCart, List<Rule> rules);
}

class PriorityBasisRule implements RuleStrategy {

    @Override
    public Rule applyRule(ShoppingCart shoppingCart, List<Rule> rules) {
        return null;
    }
}

class RuleContext {

    RuleStrategy ruleStrategy;
    // RuleEngine ruleEngine;
    RuleContext(RuleStrategy ruleStrategy) {
        this.ruleStrategy = ruleStrategy;
    }

    public void setRuleStrategy(RuleStrategy ruleStrategy) {
        this.ruleStrategy = ruleStrategy;
    }

    // public Rule getRule(ShoppingCart cart) {
       // return ruleStrategy(cart, ruleEngine.getAllRules());
    // }
}
abstract class OfferRule {
    private Rule rule;
    abstract boolean canApply(ShoppingCart cart);
}

class OfferRule1 extends OfferRule {

    // on constructor pass rule.
    @Override
    boolean canApply(ShoppingCart cart) {

        // if match this can apply
        return false;
        // else
        //rule.nextRule();
    }


}
