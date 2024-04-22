package generics.genericClass;

public class RunnerNonGenerics {
    public static void main(String[] args) {

        //create an instance from non-generic class, let's say its id was integer
        NonGenericClass obj1 = new NonGenericClass();
        obj1.setIdField(1234);  // since the type of idField is object, it accepts integer

        //create an instance from non-generic class, let's say its id was String
        NonGenericClass obj2 = new NonGenericClass();
        obj2.setIdField("advanced Java");   // since the type of idField is object, it accepts String

        // to put Object type to any other type, we've to use typeCasting
        Integer object1 = (Integer) obj1.getIdField();

        Integer object2 = (Integer) obj2.getIdField();  // ClassCastException

        System.out.println("object1 = " + object1);
        System.out.println("object2 = " + object2);

        /*
            We have 2 problems:
                1. type casting
                2. ClassCastException
         */

    }
}
