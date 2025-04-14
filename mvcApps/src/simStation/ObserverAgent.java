package simStation;

public class ObserverAgent extends Agent {
    
    public ObserverAgent() {
        super();
        this.setName("ObserverAgent");
    }

    @Override
    public void update() {
        if (world != null) {
            world.updateStatistics();
        }
    }
}
