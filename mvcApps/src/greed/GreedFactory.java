package greed;

import mvc.*;
import simstation.*;

public class GreedFactory extends SimStationFactory {

    @Override
    public Simulation makeModel() {
        return new GreedSimulation();
    }

    @Override
    public GreedView makeView(Model m) {
        return new GreedView(m);
    }

    @Override
    public String about() {
        return "Simstation: Greed \nNathan Tran, Donna Bui, Matilda Verdejo\n 2025";
    }

    //what does stats return?
    @Override
    public String[] getHelp() {
        return new String[] {
                "Greed Simulation:", "Press Start to start the simulation.",
                "Press Pause to pause the simulation while its running.",
                "Press Resume to resume the simulation after its been paused.",
                "Press Stop to stop the simulation.",
                "Press Stats to view the statistics of the simulation, returns idk???"
        };
    }

    @Override
    public String getTitle() {
        return "Greed";
    }

    //finish up buttons/commands on here


}
