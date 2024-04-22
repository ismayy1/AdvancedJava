package generics.genericInterface;

// 2 ways of implementing generic Interface
// 1st way: Generic Interface should be implemented by generic class
public class GenericInterfaceImpl <T> implements GenericInterface <T> {

    @Override
    public void print(T value) {

    }

    @Override
    public T find() {
        return null;
    }
}
