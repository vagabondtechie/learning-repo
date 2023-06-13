package me.maharana.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class AirTrafficController implements ISubject, Runnable {

    private List<IObserver> observers;
    private String currentData;

    public AirTrafficController() {
        observers = new ArrayList<>();
        new Thread(this).start();
    }

    @Override
    public synchronized boolean subscribe(IObserver o) {
        if (!observers.contains(o)) {
            observers.add(o);
            return true;
        }
        return false;
    }

    @Override
    public synchronized boolean unSubscribe(IObserver o) {
        if (o == null || !observers.contains(o)) {
            return false;
        }
        observers.remove(o);
        return true;
    }

    @Override
    public synchronized void notifyObservers() {
        if (observers.isEmpty()) {
            return;
        }
        System.out.println(String.format("[%20s] Data: %s.\n", "ATC to Airplane", currentData));
        for (IObserver ob : observers) {
            ob.notify(this, currentData);
        }
        System.out.println("===================================================================\n");
    }

    @Override
    public void run() {
        while (true) {
            currentData = UUID.randomUUID().toString();
            notifyObservers();

            Random random = new Random();
            long minSleep = Math.max(1000L, Math.round(random.nextDouble() * 4000));
            try {
                Thread.sleep(minSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
