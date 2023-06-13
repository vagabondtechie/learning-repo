package me.maharana.observer;

public interface ISubject {
    public boolean subscribe(IObserver o);
    public boolean unSubscribe(IObserver o);
    public void notifyObservers();
}
