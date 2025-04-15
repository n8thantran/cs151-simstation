package plague;

import mvc.*;
import simstation.*;

public class PlagueSimulation extends Simulation {
    private static int VIRULENCE = 50; // % chance of infection 50
    // private static int RESISTANCE = 2; // % chance of resisting infection 2
    private static int POPULATION = 50;
    public static int INFECTED;
    public static int INFECTION_LENGTH = 50; // time until recovery
    public static boolean FATAL = false;
    private static int INITIAL_INFECTED = 25;
    public static final int MAX_CHANCE = 100;

    @Override
    public void populate() {
        INFECTED = 0;
        for(int i = 0; i < POPULATION; i++) {
            addAgent(new Plague());
        }
        infectAgents(); // Infect random agents in the World
    }

    public void infectAgents() {
        for (Agent agent : getAgents()) {
            Plague a = (Plague) agent;
            if (Utilities.rng.nextInt(MAX_CHANCE) < INITIAL_INFECTED) {
                if (!a.isInfected()) {  // if not already infected
                    a.setInfected(true);
                    INFECTED++;
                }
            }
        }
    }
    
    public synchronized String stats() {
        double percentInf = Math.ceil(((double) INFECTED / POPULATION) * MAX_CHANCE);
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

    public static int getInitialInfected() {
        return INITIAL_INFECTED;
    }
    public static void setInitialInfected(int percent) {
        INITIAL_INFECTED = percent;
    }

    /* 
    public static int getResistance() {
        return RESISTANCE;
    }
    public static void setResistance(int resistance) {
        RESISTANCE = resistance;
    }
    */

    public static void main(String[] args) {
        AppPanel panel = new PlaguePanel(new PlagueFactory());
        panel.display();
    }
}
