package simStation;

import java.io.Serializable;

public class Agent implements Serializable, Runnable {
    protected int xc, yc;
    protected boolean paused, stopped;
    protected String agentName;
    transient protected Thread myThread;
    protected World world;

    public Agent() {
        this.xc = (int)(Math.random() * World.SIZE);
        this.yc = (int)(Math.random() * World.SIZE);
        this.paused = false;
        this.stopped = false;
        this.agentName = "Agent";
        this.myThread = null;
    }

    // Basic constructors
    public int getX() { return xc;}
    public int getY() { return yc;}
    public void setX(int x) { xc = x; }
    public void setY(int y) { yc = y; }
    public void setName(String name) { this.agentName = name; }
    public String getName() { return agentName; }
    public void setWorld(World world) { this.world = world;}
    
    // Methods to be overridden in implementations of simStation
    public void update() {}
    public void onStart() {}
    public void onInterrupted() {}
    public void onExit() {}

    // Synchronized methods
    public synchronized boolean isPaused() { return paused; }
    public synchronized boolean isStopped() {return stopped; }
    public synchronized void pause() { paused = true; }
    public synchronized void stop () { stopped = true; }
    public synchronized void resume() { notify(); } // wakes up the agent and the while-loop in run() will set paused to false
    
    public synchronized void start() {
        if (myThread == null) { 
        // the if-statement prevents multiple threads from being created even if start() is accidentally called more than once
            myThread = new Thread(this);
            myThread.start();
        }
    }
    
    public void run() {
        onStart();
        while (!stopped) {
            try {
                update();
                Thread.sleep(20);
                synchronized (this) { // check if paused, wait until stopped or resumed
                    while (!stopped && paused) {
                        wait();
                        paused = false; // as soon as it wakes up, it's no longer suspended
                    }
                }
            } catch (InterruptedException e) {
                onInterrupted();
            }
        }
        onExit();
    }

    
}
