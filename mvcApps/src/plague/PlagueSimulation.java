package plague;

import mvc.*;
import simstation.*;

public class PlagueSimulation extends Simulation {
    private static int VIRULENCE = 50; // % chance of infection 50
    private static int RESISTANCE = 2; // % chance of resisting infection 2
    private static int POPULATION = 50;
    private static int INFECTED;
    public static final int CHANCE = 100;
    public void populate() {
        INFECTED = 0;
        for(int i = 0; i < POPULATION; i++)
            addAgent(new Plague());
        infectAgents(); // Infect random agents in the World
    }
    public void infectAgents() {
        for (Agent agent : getAgents()) {
            Plague a = (Plague) agent;
            if (!a.isInfected() && isSusceptible(agent)) {
                    if (shouldInfect()) {
                        a.setInfected(true);
                        INFECTED++;
                    }
                }
            }
    }
    // This method tries to infect an infected Agent's neighbor.
    public void infectNeighbor(Plague agent, Plague neighbor) {
        if(agent.isInfected() && !neighbor.isInfected() && isSusceptible(neighbor)) {
            if (shouldInfect()) {
                neighbor.setInfected(true);
                INFECTED++;
            }
        }
    }
    // Method to determine if an agent is susceptible to infection
    private boolean isSusceptible(Agent agent) {
        int resistanceChance = Utilities.rng.nextInt(CHANCE);
        return resistanceChance >= RESISTANCE;
    }
    // Method to determine infection chance
    private boolean shouldInfect() {
        int infectionChance = Utilities.rng.nextInt(CHANCE);
        return infectionChance < VIRULENCE;
    }
    public synchronized String stats() {
        double percentInf = Math.ceil(((double) INFECTED / POPULATION) * CHANCE);
        return "% infected: " + percentInf;
    }

    public static int getPopulation() {
        return POPULATION;
    }
    public static void setPopulation(int population) {
        POPULATION = population;
    }

    public static int getVirulence() { // % chance of infection
        return VIRULENCE;
    }
    public static void setVirulence(int virulence) {
        VIRULENCE = virulence;
    }

    public static int getResistance() {
        return RESISTANCE;
    }
    public static void setResistance(int resistance) {
        RESISTANCE = resistance;
    }

    public static void main(String[] args) {
        AppPanel panel = new PlaguePanel(new PlagueFactory());
        panel.display();
    }
}
