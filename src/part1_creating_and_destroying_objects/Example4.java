package part1_creating_and_destroying_objects;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//Enforce non-instantiability with a private constructor

class UtilityClass {
    private UtilityClass() { //Also, this prevents the class from being subclassed
        throw new AssertionError(); //This is to avoid instantiation inside the class
    }
}

public class Example4 {

    //However, we can access the private constructor as follows using java reflect api
    public static void accessPrivateConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<UtilityClass> constructorOfUtilityClass = UtilityClass.class.getDeclaredConstructor();
        constructorOfUtilityClass.setAccessible(true);
        constructorOfUtilityClass.newInstance();
    }
}