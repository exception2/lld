package com.satyendra.lld.notifyme;

public class SMSAlertObserver implements Observer {

    private String mobileno;
    private Observable observable;

    public SMSAlertObserver(Observable observable, String mobileno) {
        this.mobileno = mobileno;
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("Send sms to " + mobileno + " with product " + observable.getData());
    }
}
