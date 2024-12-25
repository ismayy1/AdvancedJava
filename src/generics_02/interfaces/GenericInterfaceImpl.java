package generics_02.interfaces;

// Option 1: if you're implementing a generic interface,
// the class implementing the interface also should be a generic class
public class GenericInterfaceImpl<T> implements GenericInterface<T> {
    @Override
    public void print(T value) {

    }

    @Override
    public T find() {
        return null;
    }

}
