package generics.bounding;

// We can set boundary from top: in this generic class, type must extend from Number
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

}
