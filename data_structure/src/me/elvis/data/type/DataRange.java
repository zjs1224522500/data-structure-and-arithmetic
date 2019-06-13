package me.elvis.data.type;

public class DataRange {

    public static void main(String[] args) {
        System.out.println("Integer max value: " + Integer.MAX_VALUE);
        System.out.println("Integer min value: " + Integer.MIN_VALUE);
        System.out.println("Double max value: " + Double.MAX_VALUE);
        System.out.println("Double min value: " + Double.MIN_VALUE);
        System.out.println(doubleValueOutOfScope(23.0));
        Double d1 = 23.0;
        Double d2 = 24.0;
        System.out.println(d1.compareTo(d2));
    }

    public static boolean doubleValueOutOfScope(Double compareDoubleVal)
    {
        return compareDoubleVal.compareTo(Double.MAX_VALUE) > 0
                || compareDoubleVal.compareTo(Double.MIN_VALUE) < 0;
    }
}
