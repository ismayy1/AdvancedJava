package generics_02.classes;

import java.util.HashMap;

public class RunnerGeneric {
    public static void main(String[] args) {

        GenericProduct<String> book = new GenericProduct<>();
        book.setCode("AdvancedJava");

        GenericProduct<Integer> laptop = new GenericProduct<>();
        laptop.setCode(123456);

        String string = book.getCode();
        System.out.println("string = " + string);

        Integer integer = laptop.getCode();
        System.out.println("integer = " + integer);

//        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Double> hashMap = new HashMap<>();

        hashMap.put("Advjava", 99.9);

        GenericClassTwoParam<String, String> myMap = new GenericClassTwoParam<>("generic", "awesome");
    }
}
