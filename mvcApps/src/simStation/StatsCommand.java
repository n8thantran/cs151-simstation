package simStation;

import mvc.*;

public class StatsCommand extends Command {

    public StatsCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        World w = (World)model;
        w.getStatus();
    }
}
