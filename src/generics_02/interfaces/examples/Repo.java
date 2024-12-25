package generics_02.interfaces.examples;

public interface Repo<T> {
    void save(T obj);
    T find();
}
