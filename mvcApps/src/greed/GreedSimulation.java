package greed;

import mvc.*;
import simstation.*;

public class GreedSimulation extends Simulation {

    //fill in with greed info

    public static void main (String[] args) {
        AppPanel panel = new GreedPanel(new GreedFactory());
        panel.display();
    }
}
