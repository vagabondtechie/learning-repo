package me.maharana.observer;

public interface ISubject {
    public void subscribe(IObserver o);
    public void unSubscribe(IObserver o);
    public void notifyObservers();
}
