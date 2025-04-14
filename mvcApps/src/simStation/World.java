package simStation;

import mvc.*;
import java.util.*;

public abstract class World extends Model {
    public static final int SIZE = 500;
    private int clock; // simulation runtime
    private int alive; // how many agents active
    public ArrayList<Agent> agents;
    private ObserverAgent observer;

    public World() {
        this.clock = 0;
        this.alive = 0;
        this.agents = new ArrayList<>();
    }

    public void addAgent(Agent a) {
        agents.add(a);
        a.setWorld(this);
    }

    public void startAgents() {
        if (agents.isEmpty()) {
            populate(); // populate if no agents
        }
        for (Agent a : agents) {
            a.start();
        }
        // changed(); - need to implement worldfactory
    }

    public void stopAgents () {
        for (Agent a : agents) {
            a.stop();
        }
        // changed();
    }

    public void pauseAgents() {
        for (Agent a : agents) {
            a.pause();
        }
    }

    public void resumeAgents() {
        for (Agent a : agents) {
            a.resume();
        }
    }

    public abstract void populate(); // to be implemented by each simStation implementation

    public void getStatus() {

    }

    public void updateStatistics() {

    }

    public Agent getNeighbor(Agent caller, int radius) {

    }



}
