package generics.bounding;

import java.util.ArrayList;
import java.util.List;

// "?" - is a wildCard (joker), to donate unknown type
public class GenericWildCard {
    public static void main(String[] args) {

        List <Integer> intList = new ArrayList<>();
        List <Double> doubleList = new ArrayList<>();   // NOT PARENT of Integer
        List <Number> numberList = new ArrayList<>();
        List <Object> objectList = new ArrayList<>();
        List <String> stringList = new ArrayList<>();   // NOT PARENT of Integer

        addElement(intList);
        System.out.println("intList = " + intList);

//        addElement(doubleList);   // NOT PARENT of Integer
        addElement(numberList);
        System.out.println("numberList = " + numberList);

        addElement(objectList);
        System.out.println("stringList = " + stringList);

//        addElement(stringList);   // NOT PARENT of Integer

    }

    // lower Bounding
    public static void addElement (List<? super Integer> list) {    // "super Integer" => gets values from Integer and its parents
        for (int i=0; i<11; i++) {
            list.add(i);
        }
    }

}
