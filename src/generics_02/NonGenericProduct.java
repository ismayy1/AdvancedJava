package generics_02;

public class NonGenericProduct {

    Object code;

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "NonGenericProduct{" +
                "code=" + code +
                '}';
    }
}
