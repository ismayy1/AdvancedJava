package generics.genericInterface;

// 2nd way: We can decide the data type by implementing the interface
public class GenericInterfaceStringImpl implements GenericInterface<String> {
    @Override
    public void print(String value) {

    }

    @Override
    public String find() {
        return null;
    }

    @Override
    public String getSum() {
        return null;
    }
}
