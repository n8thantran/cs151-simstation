package simStation;

import java.io.Serializable;

public class Agent implements Serializable, Runnable {{
    protected int xc, yc;
    protected boolean paused, stopped;
    protected String agentName;
    protected Thread myThread;

    public Agent() {
        
    }

}
