package part1_creating_and_destroying_objects;

//Avoid finalizers and cleaners

public class Example8 {
    //Never do anything time-critical in a finalizers or cleaner(Java9)
    //e.g.- depending on finalizer to close files
}