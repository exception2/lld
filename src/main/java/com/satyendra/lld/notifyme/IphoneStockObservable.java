package com.satyendra.lld.notifyme;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class IphoneStockObservable implements Observable {

    private List<Observer> observers;
    private int stockCount;
    private String productName;

    public IphoneStockObservable(String productName) {
        this.observers = new ArrayList<>();
        this.stockCount = 0;
        this.productName = productName;
    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for(Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void updateStock(int count) {
        if(stockCount == 0 && count > 0) {
            notifyAllObservers();
        }
        stockCount = count;
    }

    @Override
    public String getData() {
        return productName;
    }
}
