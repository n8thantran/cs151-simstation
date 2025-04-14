package simStation;

import mvc.*;

public class StartCommand extends Command {

    public StartCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        World w = (World)model;
        w.startAgents();
    }
}