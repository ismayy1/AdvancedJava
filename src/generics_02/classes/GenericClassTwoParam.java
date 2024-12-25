package generics_02.classes;

public class GenericClassTwoParam<S, U> {

    private S myKey;
    private U myValue;

    public GenericClassTwoParam(S myKey, U myValue) {
        this.myKey = myKey;
        this.myValue = myValue;
    }

    public S getMyKey() {
        return myKey;
    }

    public void setMyKey(S myKey) {
        this.myKey = myKey;
    }

    public U getMyValue() {
        return myValue;
    }

    public void setMyValue(U myValue) {
        this.myValue = myValue;
    }
}
