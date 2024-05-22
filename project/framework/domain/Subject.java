package framework.domain;

import framework.integration.Observer;


public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers(String message, Customer customer);
}
