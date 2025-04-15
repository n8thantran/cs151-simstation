package simstation;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;
import mvc.*;

public class SimStationFactory implements AppFactory {

    public Model makeModel() {
        return new Simulation();
    }

    public View makeView(Model model) {
        return new SimulationView(model);
    }

    public String getTitle() {
        return "SimStation";
    }

    public String[] getHelp() {
        return new String[]{"Help"};
    }

    public String about() {
        return "Simstation: Prisoner's Dilemma \nBrandon Nguyen, Charles Manaois, Hruday Prathipati\n 2024";
    }

    public String[] getEditCommands() {
        return new String[]{"Start", "Suspend", "Resume", "Stop", "Stats"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        switch (type) {
            case "Start":
                return new StartCommand(model);
            case "Suspend":
                return new SuspendCommand(model);
            case "Resume":
                return new ResumeCommand(model);
            case "Stop":
                return new StopCommand(model);
            case "Stats":
                return statsCommand(model);
            default:
                return null;
        }
    }
    protected StatsCommand statsCommand(Model model) {
        return new StatsCommand(model);
    }
}
