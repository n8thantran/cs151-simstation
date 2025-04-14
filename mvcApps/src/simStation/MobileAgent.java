package simStation;

public class MobileAgent extends Agent {
    protected Heading heading;

    public MobileAgent() {
        super();
        this.setName("MobileAgent");
        this.heading = Heading.random();
    }

    public Heading getHeading() {
        return this.heading;
    }

    public void turn(Heading h) {
        this.heading = h;
    }

    public void move(int steps) {
        for (int i = 0; i < steps; i++) {
            switch (heading) {
                case NORTH:
                yc--;
                break;
            case SOUTH:
                yc++;
                break;
            case EAST:
                xc++;
                break;
            case WEST:
                xc--;
                break;
            // we can also add northeast, northwest, etc. but not needed
            }

            // Wrap around if the agent goes out of bounds
            if (xc < 0) { xc += World.SIZE; }
            else if (xc >= World.SIZE) { xc -= World.SIZE; }
            else if (yc < 0) { yc += World.SIZE; }
            else if (yc >= World.SIZE) { yc -= World.SIZE; }
        }
    }

}
