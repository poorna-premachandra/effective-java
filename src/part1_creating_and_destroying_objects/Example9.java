package part1_creating_and_destroying_objects;

//Prefer try-with-resources to try-finally

public class Example9 {
    //try-finally is no longer the best way to close resources. Also it is ugly if you use with more than one resource.
    //try-with-resources is the best way to close resources. Also it is more readable when used on multiple resources.
    //If you write a class that represents a resource that must be closed, your class should implement AutoClosable too.
    //Also try-with-resources can be paired with a catch close.
}
