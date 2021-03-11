package application.domain;

import application.contracts.Observer;

public class Race implements Observer<FrogRun> {

    private int position = 0;

    public Race(Frog[] frogs, int finalLength) {
        for (int i = 0; i < frogs.length; i++) {
            var run = new FrogRun(frogs[i], finalLength);
            run.subscribe(this);
            run.start();
        }
    }

    @Override
    public void observe(FrogRun subject) {
        System.out.println(
            subject.frog() + " chegou em " + (position + 1) + "° lugar\n"
        );
        position++;
    }
}
