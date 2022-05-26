package part1_creating_and_destroying_objects;

public class Example3 {

    //3 methods of implementing singleton

    //NOTE: Privileged client could access private constructor reflectively with AccessibleObject.setAccessible method(not relevant to method 3). As a solution, modify the constructor to throw an exception when it asked to create a second instance.
    //NOTE: Be careful when serializing singleton classes(not relevant to method 3). Implementing Serializable interface is not enough. Should add a readResolve method to read the single instance each time.

}

//1 method - using public static instance variable
class SingletonMethodFirst {
    public static final SingletonMethodFirst INSTANCE = new SingletonMethodFirst();

    private SingletonMethodFirst() {
    }
}

//2 method - using public static factory method
class SingletonMethodSecond {
    private static final SingletonMethodSecond INSTANCE = new SingletonMethodSecond();

    private SingletonMethodSecond() {
    }

    public static SingletonMethodSecond getInstance() {
        return INSTANCE;
    }
}

//3 method - using single element enum
enum SingletonMethodThird {
    INSTANCE;
}

