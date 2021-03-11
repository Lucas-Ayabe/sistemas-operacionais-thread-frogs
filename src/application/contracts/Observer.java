package application.contracts;

public interface Observer<T> {
    public void observe(T subject);
}
