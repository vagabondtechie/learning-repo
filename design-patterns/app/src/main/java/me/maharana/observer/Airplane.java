package me.maharana.observer;

import java.util.Random;

public class Airplane implements IObserver, Runnable {

    private String flightName;
    private ISubject subject;
    private Random currentPosition;

    public Airplane(String flightName, ISubject subject) {
        this.flightName = flightName;
        this.subject = subject;
        this.currentPosition = new Random();
        System.out.println(String.format("[%s to ATC] Taking off.", flightName));
        new Thread(this).start();
    }

    @Override
    public void notify(ISubject subject, Object data) {
        System.out.println(String.format("[%20s] Data: %s.\n", flightName + " to ATC", data));
    }

    @Override
    public void run() {
        while (true) {
            if (destinationReached()) {
                land();
                synchronized (subject) {
                    subject.unSubscribe(this);
                    break;
                }
            }
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean destinationReached() {
        return currentPosition.nextInt(65536) % 7 == 0;
    }

    private void land() {
        System.out.println(String.format("[%20s] Landing Complete.\n", flightName + " to ATC"));
    }
}
