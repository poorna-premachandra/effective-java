package part2_methods_common_to_all_objects;

//Always override hashCode when overriding equals

public class Example2 {

    /*
    When overriding hashCode pay attention to followings.
        1. When hashCode method is invoked repeatedly, it must consistently return the same value.
        2. If two objects are equal according to equals, then those two object should produce the same hash.
        3. If two objects are unequal, it is not necessary to produce the same hash, but doing so will improve the performance of hash tables.
     */
}

final class PhoneNumberD {
    private final short areaCode, prefix, lineNum;

    public PhoneNumberD(int areaCode, int prefix, int lineNum) {
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
        if (o == this) return true;
        if (!(o instanceof PhoneNumberD)) return false;
        PhoneNumberD pn = (PhoneNumberD) o;
        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
    }

    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode); //1. initialize result variable and assign it with the hashCode value of first significant field
        result = 31 * result + Short.hashCode(prefix); //2. Calculate hashCodes using other 'significant' fields one by one. [result = 31 * result + c]
        result = 31 * result + Short.hashCode(lineNum);
        // If field is primitive, use FieldType.hashCode(f).
        // If field is null, use 0.
        // If it is an object, invoke hashCode of that object.
        // If it is an array and none of elements are significant, use a constant(but not 0)
        // If it is an array and all elements are significant, use Arrays.hashCode()
        // If it is an array and only some elements are significant, calculate hashCodes of those elements separately and combine the results like in step 2

        return result; //3. return hashCode
    }

    /*
    Good alternative, but slow performance.
        @Override
        public int hashCode() {
            return Objects.hash(lineNum, prefix, areaCode);
        }
    */
}