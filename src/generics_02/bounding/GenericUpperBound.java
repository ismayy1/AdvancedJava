package generics_02.bounding;

// We can upper bound parameters for generic types.
// T: Only sub classes of numbers
// T: SHORT, BYTE, INTEGER, DOUBLE, LONG, FLOAT, NUMBER
public class GenericUpperBound<T extends Number> {

    public T[] numberArray;

    public Double getAverage() {

        double sum = 0;

        for (T number : this.numberArray) {
            sum += number.doubleValue();
        }
        double avg = sum/this.numberArray.length;
        return avg;
    }

    public static void main(String[] args) {

        Integer[] integers = {5, 30, 2, 6, 9};
        Double[] doubles = {0.5, 87.2, 10.9, 3.8};
        String[] strings = {"Generics", "can", "be", "upper-bounded."};

        GenericUpperBound<Integer> obj1 = new GenericUpperBound<>();
        obj1.numberArray = integers;
        System.out.println("obj1.getAverage() = " + obj1.getAverage());

        GenericUpperBound<Double> obj2 = new GenericUpperBound<>();
        obj2.numberArray = doubles;
        System.out.println("obj2.getAverage() = " + obj2.getAverage());

//        It's not a number type, hence we're not allowed to assign it strings
//        GenericUpperBound<String> obj3 = new GenericUpperBound<>();
//        obj3.numberArray = strings;
//        System.out.println("obj3.getAverage() = " + obj3.getAverage());
    }
}
