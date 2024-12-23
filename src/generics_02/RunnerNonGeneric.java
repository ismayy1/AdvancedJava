package generics_02;

public class RunnerNonGeneric {
    public static void main(String[] args) {

        NonGenericProduct book = new NonGenericProduct();
        book.setCode("advJava");;

        NonGenericProduct laptop = new NonGenericProduct();
        laptop.setCode(123456);
    }
}
