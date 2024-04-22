package generics.genericClass;

/*
    E- element
    K- Key
    V- Value
    T- Type
    S, U, V .....

    The letter doesn't matter
 */

//Goal to store different types of fields without creating different field

public class GenericClass <T> {

    private T idField;  // Any data type except primitive

    private T str;
    private T name;

    public Object getIdField() {
        return idField;
    }
    public void setIdField(T idField) {
        this.idField = idField;
    }

}
