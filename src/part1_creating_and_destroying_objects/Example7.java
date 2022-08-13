package part1_creating_and_destroying_objects;

//eliminate obsolete object references

import java.util.EmptyStackException;

public class Example7 {

    //e.g.- null out the element(obsolete reference) that's being popped off from the stack, so that it will be garbage collected

    //correct way of popping an element from stack
    /*public Object pop() {
        if (size == 0) throw new EmptyStackException();
        Object result = element[--size];
        element[size] = null;     <- nulling out reference
        return result;
    }*/

    //nulling out should be rarely used.

    //best way to is to let the variable that contains the reference fall out of scope
    //This occurs naturally if we define each variable in the narrowest possible scope

    //Generally memory leaks can be happened in,
    //1.classes that manage its own memory
    //2.caches
    //3.listeners and callbacks
}
