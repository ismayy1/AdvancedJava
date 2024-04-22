package generics.genericClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GenericRunner {
    public static void main(String[] args) {

        // Data type of generic class is decided while creating the instance of it
        GenericClass<Integer> obj1 = new GenericClass<>();  // T= Integer type
        obj1.setIdField(8237);

        GenericClass<String> obj2 = new GenericClass<>();   // T= String type
        obj2.setIdField("String type Generics");

//        String str = obj1.getIdField();   // we won't get ClassCastException

        System.out.println("obj1 = " + obj1.getIdField());
        System.out.println("obj2 = " + obj2.getIdField());

        // --------
        ArrayList<String> strList = new ArrayList<>();
        strList.add("v");   // accepts only String

        // ------ HashMap
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("123", "2342");


        //==================== Instance From MultiParamGenerics =======================
        GenericClassWithTwoParams<String, Integer, String> genericClassWithTwoParams =
                new GenericClassWithTwoParams<>("smth", 23, "smth2");

    }
}
