package generics_02.bounding;

import java.util.ArrayList;
import java.util.List;

public class GenericWithWildcard {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        List<Double> doubles = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        List<Number>numbers = new ArrayList<>();
        List<Object> objects = new ArrayList<>();

        System.out.println("============= Lower Bounding =============");

        addElements(integers);
        System.out.println(integers);   // works, but it will not work with strings nor with doubles,
                                        // bcs they are not the parent of Integer

        addElements(numbers);

        printElements(integers);
        printElements(doubles);
        printElements(strings);
        printElements(numbers);
        printElements(objects);

        printElements(multiplyByTwo(integers));
    }

//    method with example of Lower Bounding
    public static void addElements(List<? super Integer> list) {
        for (int i = 1; i < 11; i++) {
            list.add(i);
        }
    }

    public static List<?> multiplyByTwo(List<? extends Number> list) {
        List<Double> newList = list.stream().map(t -> 2 * t.doubleValue()).toList();
        return newList;
    }

    public static void printElements(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public static <T> void addElementsToList(List<T> list, T element) {
        list.add(element);
    }

    // NOTE: List<T> and List<?> are similar but not the same
}
