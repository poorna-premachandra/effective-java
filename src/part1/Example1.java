package part1;

//Consider using static factory methods instead of constructors, or to use along with constructors

public class Example1 {
    public static void main(String[] args) {
        //create only single instance with each call
        System.out.println(Animal.getSingleInstance());
        System.out.println(Animal.getSingleInstance());
        System.out.println(Animal.getSingleInstance());

        //create different instances with each call
        System.out.println(Animal.newInstance());
        System.out.println(Animal.newInstance());
        System.out.println(Animal.newInstance());

        //create an object of subtype
        System.out.println(Animal.getDog());
    }
}

class Animal {
    private static Animal animal;

    public static Animal getSingleInstance() { //static factory method
        if (animal == null) {
            animal = new Animal();
        }
        return animal;
    }

    public static Animal newInstance() { //static factory method
        return new Animal();
    }

    public static Animal getDog() { //static factory method
        return new Dog();
    }
}

class Dog extends Animal {
}
