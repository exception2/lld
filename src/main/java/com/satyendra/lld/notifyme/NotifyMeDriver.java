package com.satyendra.lld.notifyme;

public class NotifyMeDriver {
    public static void main(String[] args) {
        Observable observable = new IphoneStockObservable("IPhone");
        Observer o1 = new EmailAlertObserver(observable, "abc@email.com");
        Observer o2 = new EmailAlertObserver(observable, "def@email.com");
        Observer o3 = new EmailAlertObserver(observable, "ghi@email.com");
        Observer o4 = new EmailAlertObserver(observable, "jkl@email.com");

        Observer o5 = new SMSAlertObserver(observable, "1234");
        Observer o6 = new SMSAlertObserver(observable, "5678");

        observable.add(o1);
        observable.add(o2);
        observable.add(o3);
        observable.add(o4);
        observable.add(o5);
        observable.add(o6);

        observable.updateStock(1);

        observable.updateStock(0);
        observable.remove(o1);
        observable.updateStock(2);

    }
}
