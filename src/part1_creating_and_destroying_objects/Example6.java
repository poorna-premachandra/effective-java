package part1_creating_and_destroying_objects;

//Avoid creating unnecessary objects

public class Example6 {
    public static void main(String[] args) {
        String s1 = new String("Hello"); //Don't do this
        String s2 = "Hello"; //Do this

        //'static factory method' is preferred over 'constructors' on immutable classes
        Boolean.valueOf("true"); //Use this
        new Boolean("true"); //Don't use this (also this is deprecated in Java 9)

        //keySet method in Map interface return a 'single instance' consisting all the keys in the map
        //Therefore, it is harmless to create multiple instances of keySet view object

        //autoboxing is also result in creating unnecessary objects
        //prefer primitives to boxed primitives and watch out for unintentional autoboxing

        //avoid maintaining an object pool manually unless objects are extremely heavyweight(e.g.- database connection)
    }
}
