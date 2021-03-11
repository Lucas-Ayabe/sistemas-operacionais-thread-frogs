package application;

import application.domain.Frog;
import application.domain.Race;

public class Main {

    public static void main(String[] args) {
        var frogs = new Frog[5];
        int maxJump = 2;

        for (int i = 0; i < frogs.length; i++) {
            frogs[i] = new Frog(i + 1, maxJump);
        }

        new Race(frogs, 20);
    }
}
