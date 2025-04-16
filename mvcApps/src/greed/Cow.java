package greed;

import simstation.*;
import mvc.*;
import java.awt.*;
import java.awt.color.*;

public class Cow extends MobileAgent {
    private int energy = 100;
    private static int greediness = 25;
    private Color color = Color.RED;

    public Cow() {
        super();
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public Color getColor() {
        return color;
    }

    public void update() {
        // Cow is already dead
        if (energy <= 0) {
            return;
        }

        Patch patch = ((Meadow) world).getPatch(xc, yc);
        if (patch == null) {
            move();  // Move if no valid patch exists
            return;
        }
        boolean ate = patch.eatMe(this, greediness);

        if (!ate) {
            int moveCost = ((Meadow) world).getMoveEnergy();
            if (energy >= moveCost) {
                move();
                energy -= moveCost;
            } else {
                try {
                    patch.enteringWaitingRoom(this);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        if (energy <= 0) {
            passAway();
        }
    }

    public int getGreed() {
        return greediness;
    }

    public void reduceEnergy(int amount) {
        energy -= amount;
    }

    public int getEnergy() {
        return energy;
    }

    public void passAway() {
        energy = 0;
        setColor(Color.WHITE); // Cow's color changes to white when it dies.
        stop();
    }

    public void applyWaitPenalty() {
        int penalty = ((Meadow) world).getWaitPenalty();
        reduceEnergy(penalty);
    }

    public void move() {
        // Generate a random move direction: -1, 0, or 1 for both x and y
        int deltaX = Utilities.rng.nextInt(3) - 1;
        int deltaY = Utilities.rng.nextInt(3) - 1;

        // Update the cow's position (keeping within bounds)
        xc = Math.max(0, Math.min(xc + deltaX, ((Meadow) world).SIZE - 1));
        yc = Math.max(0, Math.min(yc + deltaY, ((Meadow) world).SIZE - 1));
    }
}
