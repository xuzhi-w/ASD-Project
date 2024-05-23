package framework.integration;

import framework.domain.Customer;

import java.util.Objects;

public class EmailSender implements Observer {

    private static volatile EmailSender instance;
    private EmailSender() {
    }
    public static EmailSender getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (EmailSender.class) {
                if (Objects.isNull(instance)) {
                    instance = new EmailSender();
                }
            }
        }
        return instance;
    }
    @Override
    public void update(String message, Customer customer) {
        System.out.println("Email sent to " + customer.getEmail() + ": " + message);
    }
//    List<Observer> observers;
//    public EmailSender() {
//        observers = new ArrayList<Observer>();
//    }
//    @Override
//    public void registerObserver(Observer o) {
//        observers.add(o);
//    }
//
//    @Override
//    public void removeObserver(Observer o) {
//        observers.remove(o);
//    }
//
//    @Override
//    public void notifyObservers(String message, Customer customer) {
//        for (Observer o : observers) {
//            o.update(message, customer);
//        }
//    }
}
