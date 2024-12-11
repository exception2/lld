package com.satyendra.lld.notifyme;

public class EmailAlertObserver implements Observer {

    private String email;
    private Observable observable;

    public EmailAlertObserver(Observable observable, String email) {
        this.observable = observable;
        this.email = email;
    }

    @Override
    public void update() {
        System.out.println("Send email to " + email + " with product " + observable.getData());
    }
}
