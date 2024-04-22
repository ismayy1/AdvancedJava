package generics.genericMethods;

import java.util.Arrays;

public class GenericMethod {
    public static void main(String[] args) {

        Integer [] intArr = {3, 6, 8, 3, 7};
        Double [] doubleArr = {3.5, 6.7, 3.5, 6.0};
        String [] strArr = {"Using", "Generics", "is", "helpful"};

        System.out.println("========= Printed with printArr method ==========");
        printArr(intArr);
//        printArr(doubleArr);  // type err

        System.out.println("========= Printed with printArrWithGenericMethod method ==========");
        printArrWithGenericMethod(intArr);
        printArrWithGenericMethod(doubleArr);
        printArrWithGenericMethod(strArr);

        System.out.println("========= Return first element of an Array with generic Method ==========");
        int firstEl1 = returnFirstElement(intArr);
        Double firstEl2 = returnFirstElement(doubleArr);
        String firstEl3 = returnFirstElement(strArr);

        System.out.println("firsEl1 = " + firstEl1);
        System.out.println("firstEl2 = " + firstEl2);
        System.out.println("firstEl3 = " + firstEl3);

        System.out.println("========= Return generic method with more than 1 arg ==========");
        printArrAndEl(intArr, 33);
        printArrAndEl(strArr, "Generics");


    }

    // Method to print an integer array of elements
    public static void printArr (Integer[] arr) {
        Arrays.stream(arr).forEach(t-> System.out.print(t + " "));
        System.out.println();
    }

    // Generic Method
    public static <T> void printArrWithGenericMethod (T[] arr) {
        Arrays.stream(arr).forEach(t-> System.out.print(t + " "));
        System.out.println();
    }

    // Generic method to return generic data type
    public static <T> T returnFirstElement (T[] arr) {
        T firstEl = arr[0];
        return firstEl;
    }

    // Method more than 1 generic value
    public static <S, U> void printArrAndEl (S[] arr, U element) {
        Arrays.stream(arr).forEach(t-> System.out.print(t + " "));
        System.out.println(element);
    }

}
