package generics_02.classes;

public class GenericProduct<T> {

    private T code;

    public T getCode() {
        return code;
    }

    public void setCode(T code) {
        this.code = code;
    }
}
