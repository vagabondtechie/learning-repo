package me.maharana.observer;

public interface IObserver {
    public void notify(ISubject subject, Object data);
}
