package generics_02;

public class RunnerGeneric {
    public static void main(String[] args) {

        GenericProduct<String> book = new GenericProduct<>();
        book.setCode("AdvancedJava");

        GenericProduct<Integer> laptop = new GenericProduct<>();
        laptop.setCode(123456);

        String string = book.getCode();
    }
}
