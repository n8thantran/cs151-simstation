package simStation;

import mvc.*;

public class StopCommand extends Command {

    public StopCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        World w = (World)model;
        w.stopAgents();
    }
}
