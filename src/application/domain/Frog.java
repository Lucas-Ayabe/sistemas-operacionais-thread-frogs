package application.domain;

import java.util.Random;

public class Frog {

    private int identity;
    private int maxJump;
    private int position = 0;
    private Random generator = new Random();

    public Frog(int identity, int maxJump) {
        this.identity = identity;
        this.maxJump = maxJump;
    }

    public int jump() {
        position += generator.nextInt(maxJump);
        return position;
    }

    @Override
    public String toString() {
        return "Sapo n° " + identity;
    }
}
