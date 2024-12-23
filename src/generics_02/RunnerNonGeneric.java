package generics_02;

public class RunnerNonGeneric {
    public static void main(String[] args) {

        NonGenericProduct book = new NonGenericProduct();
        book.setCode("advJava");;

        NonGenericProduct laptop = new NonGenericProduct();
        laptop.setCode(123456);


        String string = (String) book.getCode();
        String string2 = (String) laptop.getCode(); //ClassCastException

        System.out.println(string);
        System.out.println(string2);
    }
}
