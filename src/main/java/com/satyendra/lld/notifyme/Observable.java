package com.satyendra.lld.notifyme;

public interface Observable {

    void add(Observer observer);
    void remove(Observer observer);
    void notifyAllObservers();
    void updateStock(int count);

    String getData();
}
