package generics.genericClass;

public class GenericClassWithTwoParams <T, E, S> {

    private S var1;
    private E var2;
    private T var3;

    public GenericClassWithTwoParams(S car1, E var2, T var3) {
        this.var1 = car1;
        this.var2 = var2;
        this.var3 = var3;
    }

    public S getCar1() {
        return var1;
    }
    public E getVar2() {
        return var2;
    }
    public T getVar3() {
        return var3;
    }

    public void setCar1(S car1) {
        this.var1 = car1;
    }
    public void setVar2(E var2) {
        this.var2 = var2;
    }
    public void setVar3(T var3) {
        this.var3 = var3;
    }
}
