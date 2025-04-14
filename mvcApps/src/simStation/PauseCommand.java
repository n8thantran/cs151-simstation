package simStation;

import mvc.*;

public class PauseCommand extends Command {

    public PauseCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        World w = (World)model;
        w.pauseAgents();
    }
}
