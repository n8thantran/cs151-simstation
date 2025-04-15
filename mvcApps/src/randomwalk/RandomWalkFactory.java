package randomwalk;

import mvc.Model;
import simstation.SimStationFactory;

class RandomWalkFactory extends SimStationFactory {
    @Override
    public Model makeModel() { return new RandomWalkSimulation(); }
    @Override
    public String getTitle() { return "Random Walks";}
}
