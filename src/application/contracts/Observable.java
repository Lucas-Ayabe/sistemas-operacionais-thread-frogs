package application.contracts;

public interface Observable<T> {
    public T subscribe(Observer<T> observer);

    public T dispatch();
}
