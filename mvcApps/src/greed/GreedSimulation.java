package greed;

import mvc.*;
import simstation.*;
import javax.swing.SwingUtilities;

public class GreedSimulation extends Meadow {
    private int greediness = 25;
    private static int growBackRate = 1;
    private static int moveEnergy = 10;

    public int getGreed() {
        return greediness;
    }

    public void setGreed(int value) {
        greediness = value;
    }
    public synchronized String getStats() {
        long alive = getAgents().stream()
                .filter(a -> a instanceof Cow && ((Cow) a).getEnergy() > 0)
                .count();
        return "Alive Cows: " + alive;
    }


    @Override
    public int getGrowBackRate() {
        return growBackRate;
    }

    @Override
    public void setGrowBackRate(int rate) {
        growBackRate = rate;
    }

    @Override
    public int getMoveEnergy() {
        return moveEnergy;
    }

    @Override
    public void setMoveEnergy(int energy) {
        moveEnergy = energy;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppPanel panel = new GreedPanel(new GreedFactory());
            panel.display();
        });
    }
}
