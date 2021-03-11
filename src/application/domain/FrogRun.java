package application.domain;

import application.contracts.Observable;
import application.contracts.Observer;
import java.util.ArrayList;
import java.util.List;

public class FrogRun extends Thread implements Observable<FrogRun> {

    private Frog frog;
    private int finalLength;
    private int position = 0;
    private boolean finished = false;
    private List<Observer<FrogRun>> observers = new ArrayList<>();

    public FrogRun(Frog frog, int finalLength) {
        this.frog = frog;
        this.finalLength = finalLength;
    }

    public FrogRun subscribe(Observer<FrogRun> observer) {
        this.observers.add(observer);
        return this;
    }

    public FrogRun dispatch() {
        this.observers.forEach(observer -> observer.observe(this));
        return this;
    }

    public boolean isFinished() {
        return finished;
    }

    public int position() {
        return position;
    }

    public Frog frog() {
        return frog;
    }

    @Override
    public void run() {
        var startPosition = 0;
        int deltaSpace = 0;

        while (position < finalLength) {
            position = frog.jump();
            deltaSpace = position - startPosition;
            startPosition = position;

            System.out.println(
                frog +
                " pulou " +
                deltaSpace +
                " metros e agora está na posição " +
                position
            );
        }

        if (position > 20) {
            System.out.println(
                frog +
                " pulou " +
                deltaSpace +
                " metros e agora está na posição " +
                position
            );
        }

        this.finished = true;
        System.out.println(frog + " finalizou a corrida\n");
    }
}
