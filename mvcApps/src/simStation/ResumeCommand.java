package simStation;

import mvc.*;

public class ResumeCommand extends Command {

    public ResumeCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        World w = (World)model;
        w.resumeAgents();
    }
}
