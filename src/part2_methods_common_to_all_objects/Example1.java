package part2_methods_common_to_all_objects;

//Obey the general contract when overriding equals

public class Example1 {

    /*
    Do not override 'equals' method if,
        1. Each instance of the class is inherently unique. (e.g. - Thread class)
        2. No need for the class to provide a 'logical equality' test (e.g. - Checking whether two different regex patterns represent the same value)
        3. Superclass has already overridden equals, and the superclass behaviour is appropriate for this class (e.g. - 'Set' inherit equals implementation from 'AbstractSet', List from AbstractList and Map from AbstractMap)
        4. Class is private/ package is private, and it is certain equals method will never be invoked
     */

    /*
    When overriding, it should follow principles
        1. Reflexive - x.equals(x) must be true
        2. Symmetric - x.equals(y) return true iff y.equals(x)
        3. Transitive - if x.equals(y) true and y.equals(z) true, then x.equals(z) should be true
        4. consistent - multiple invocation of x.equals(y) must consistently return true or consistently return false
        5. non nullity - x.equals(null) must return false
     */

    //ALWAYS OVERRIDE hashCode() WHEN OVERRIDING equals()

    public static void main(String[] args) {

    }
}

final class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true; //1 - check if argument refer to the object(improves performance)
        if (!(o instanceof PhoneNumber)) return false; //2 - check is type of argument is correct
        PhoneNumber pn = (PhoneNumber) o; //3 - cast
        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode; //4 - check for each 'significant' fields
    }
}

