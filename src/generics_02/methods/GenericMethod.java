package generics_02.methods;

import java.util.Arrays;

public class GenericMethod {

    public static void printArray(Integer[] array) {
        Arrays.stream(array).forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    public static void printArray(Double[] array) {
        Arrays.stream(array).forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    public static void printArray(String[] array) {
        Arrays.stream(array).forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    public static <T> void printArrayGeneric(T[] array) {
        Arrays.stream(array).forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    public static <T> T getFirst(T[] array) {
        T first = array[0];
        return first;
    }

    public static <T, U> void printArrayAndElement(T[] array, U element) {
        Arrays.stream(array).forEach(t -> System.out.print(t + " "));
        System.out.println();
        System.out.println(element);
    }

    /*  // the first index is an object of type T, that's why we can't do the assignment
        public static <T, U> void replaceFirstElement(T[] array, U element) {
            array[0] = element;
        }
     */

    public static void main(String[] args) {

        String[] stringArray = {"Advanced", "Java", "is", "great"};
        Integer[] integerArray = {0, 10, 90, 30};
        Double[] doubleArray = {4.7, 50.3, 99.9, 100.1};

        printArrayGeneric(stringArray);
        printArrayGeneric(integerArray);
        printArrayGeneric(doubleArray);

        System.out.println("***************");

        System.out.println(getFirst(stringArray));
        System.out.println(getFirst(doubleArray));

        System.out.println("***************");

        printArrayAndElement(integerArray, getFirst(doubleArray));
    }
}
