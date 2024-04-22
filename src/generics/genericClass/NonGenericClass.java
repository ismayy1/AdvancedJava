package generics.genericClass;

//Goal to store different types of fields without creating different field

public class NonGenericClass {

    private Object idField;

    //Object type:
    //if the id was String, we have to create field
    // if the id was Integer, we have to create Integer field

//    getters and setters


    public Object getIdField() {
        return idField;
    }
    public void setIdField(Object idField) {
        this.idField = idField;
    }
}
