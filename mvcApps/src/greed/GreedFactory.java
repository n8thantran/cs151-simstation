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

    @Override
    public String[] getHelp() {
        return new String[] {
                "Greed Simulation:", "Press Start to start the simulation.",
                "Press Pause to pause the simulation while its running.",
                "Press Resume to resume the simulation after its been paused.",
                "Press Stop to stop the simulation.",
                "Press Stats to view the statistics of the simulation, returns # of alive cows and clock"
        };
    }

    @Override
    public String getTitle() {
        return "Greed";
    }

    public Command[] getCommands() {
        Simulation model = makeModel();
        return new Command[] {
                new StartCommand(model),
                new SuspendCommand(model),
                new ResumeCommand(model),
                new StopCommand(model),
                new StatsCommand(model)
        };
    }
}
