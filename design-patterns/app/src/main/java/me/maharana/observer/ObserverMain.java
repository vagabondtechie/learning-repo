package me.maharana.observer;

public class ObserverMain {
    public static void main(String[] args) {
        ISubject atc = new AirTrafficController();
        IObserver airplane1 = new Airplane("Indigo", atc);
        IObserver airplane2 = new Airplane("Air India", atc);
        IObserver airplane3 = new Airplane("Jet", atc);
        IObserver airplane4 = new Airplane("Vistara", atc);

        atc.subscribe(airplane1);
        atc.subscribe(airplane2);
        atc.subscribe(airplane3);
        atc.subscribe(airplane4);
    }
}
