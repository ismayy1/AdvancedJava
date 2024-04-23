package generics.genericInterface.useCase;

public interface Repo <T, S> {

    void save(T obj);

    T findById(S id);

}
