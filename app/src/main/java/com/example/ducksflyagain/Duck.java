package com.example.ducksflyagain;

import java.util.ArrayList;

public class Duck implements Runnable {
    private ArrayList<Quackable> listeners = new ArrayList<>();
    private boolean silent;
    private Thread thread;

    public Duck() {
        thread = new Thread(this);
    }

    public boolean isSilent() {
        return silent;
    }

    public void setSilent(boolean silent) {
        this.silent = silent;
    }

    public void beginQuack() {
        thread.run();
        System.out.println("Quacking started.");
    }

    public void addListener(Quackable quackable) {
        listeners.add(quackable);
    }

    public void removeListener(Quackable quackable) {
        listeners.remove(quackable);
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while(true) {
            try {
                setSilent(!silent);

                System.out.println("Duck is quacking : " + silent);

                for (Quackable q : listeners) {
                    q.quack(silent);
                }

                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
