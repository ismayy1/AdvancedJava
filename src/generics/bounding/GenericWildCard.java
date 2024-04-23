package generics.bounding;

import java.util.ArrayList;
import java.util.List;

// "?" - is a wildCard (joker), for unknown data type
public class GenericWildCard {
    public static void main(String[] args) {

        List <Integer> intList = new ArrayList<>();
        List <Double> doubleList = new ArrayList<>();   // NOT PARENT of Integer
        List <Number> numberList = new ArrayList<>();
        List <Object> objectList = new ArrayList<>();
        List <String> stringList = new ArrayList<>();   // NOT PARENT of Integer

        System.out.println("========= Lower Bounding method with wildCard =========");
        addElement(intList);
        System.out.println("intList = " + intList);

//        addElement(doubleList);   // NOT PARENT of Integer
        addElement(numberList);
        System.out.println("numberList = " + numberList);

        addElement(objectList);
        System.out.println("stringList = " + stringList);

//        addElement(stringList);   // NOT PARENT of Integer

        System.out.println("========= Upper Bounding method with wildCard =========");
        multiplyByTwo(intList);
        multiplyByTwo(doubleList);
        multiplyByTwo(numberList);
//        multiplyByTwo(stringList);    // NOT CHILD of NUMBER
//        multiplyByTwo(objectList);    // NOT CHILD of NUMBER

    }

    // lower Bounding
    public static void addElement (List<? super Integer> list) {    // "super Integer" => gets values from Integer and its parents
        for (int i=0; i<11; i++) {
            list.add(i);
        }
    }

    // method upper bounding
    public static void multiplyByTwo (List<? extends Number> list) { // "extends Number"=> gets values from all children of Number class
        list.stream().map(t-> 2*t.doubleValue());
    }

    public static <T> void addElementToList (List<T> list, T element) {
        list.add(element);
    }

    public static void addElementToList (List<?> list) {
        list.remove(2);
    }

}
