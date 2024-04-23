package generics.bounding;

// We can set boundary from top: in this generic class, type must extend from Number
// as long as your obj is extending from Number data type,
// then it'll work with all numeric type (Integer, Double, Float...)
public class GenericUpperBounding <T extends Number> {

    public T[] numberArr;

    // method to calculate avg of numberArr
    public Double getAverage () {
        double sum = 0;
        for(T t: this.numberArr) {
            sum += t.doubleValue();
        }
        return sum / this.numberArr.length;
    }

    public static void main(String[] args) {

        Integer [] intArr = {3, 6, 8, 3, 7};
        Double [] doubleArr = {3.5, 6.7, 3.5, 6.0};
        String [] strArr = {"Using", "Generics", "is", "helpful"};

        GenericUpperBounding obj1 = new GenericUpperBounding();
        obj1.numberArr = intArr;
        System.out.println("obj1.getAverage() = " + obj1.getAverage());

        GenericUpperBounding obj2 = new GenericUpperBounding();
        obj2.numberArr = doubleArr;
        System.out.println("obj2.getAverage() = " + obj2.getAverage());

//        GenericUpperBounding obj3 = new GenericUpperBounding();
//        obj2.numberArr = strArr;    // String is NOT a Number

    }

}
