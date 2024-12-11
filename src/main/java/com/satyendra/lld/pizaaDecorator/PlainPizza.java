package com.satyendra.lld.pizaaDecorator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlainPizza implements Pizza {
    @Override
    public double cost() {
        return 100.0;
    }

    @Override
    public String descriptions() {
        return "Plain";
    }
}
